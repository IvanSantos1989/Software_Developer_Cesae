import SwiftUI

extension Color {
    static let appPrimary = Color(red: 0.12, green: 0.43, blue: 0.95)
    static let appSecondary = Color(red: 0.93, green: 0.96, blue: 1.0)
}

struct AppLogoView: View {
    var body: some View {
        ZStack {
            RoundedRectangle(cornerRadius: 28, style: .continuous)
                .fill(LinearGradient(colors: [.appPrimary, .blue.opacity(0.75)],
                                     startPoint: .topLeading, endPoint: .bottomTrailing))
                .frame(height: 140)
                .shadow(radius: 10)
            HStack(spacing: 16) {
                Image(systemName: "checkmark.seal.fill")
                    .font(.system(size: 48, weight: .bold))
                    .foregroundColor(.white)
                    .shadow(radius: 2)
                VStack(alignment: .leading) {
                    Text("ToDo List")
                        .font(.title.bold()).foregroundColor(.white)
                    Text("Trabalho Prático iOS — SwiftUI")
                        .font(.subheadline).foregroundColor(.white.opacity(0.9))
                }
            }
        }
        .padding(.vertical, 6)
    }
}

struct ContentView: View {
    @EnvironmentObject var vm: TaskViewModel
    @State private var showingAdd = false
    @State private var showingAbout = false
    @State private var confirmClear = false
    @State private var search = ""
    
    var filtered: [Task] {
        if search.trimmingCharacters(in: .whitespacesAndNewlines).isEmpty { return vm.tasks }
        return vm.tasks.filter {
            $0.title.localizedCaseInsensitiveContains(search) ||
            $0.description.localizedCaseInsensitiveContains(search) ||
            $0.category.rawValue.localizedCaseInsensitiveContains(search)
        }
    }
    
    var body: some View {
        NavigationStack {
            List {
                Section { AppLogoView().listRowInsets(EdgeInsets()) }
                    .listRowBackground(Color.appSecondary)
                
                if filtered.isEmpty {
                    ContentUnavailableView("Sem tarefas", systemImage: "tray", description: Text("Toque em **Nova** para adicionar uma tarefa."))
                        .frame(maxWidth: .infinity, alignment: .center)
                        .listRowBackground(Color.clear)
                } else {
                    ForEach(filtered) { task in
                        NavigationLink {
                            AddEditTaskView(existingTask: task)
                        } label: {
                            TaskRowView(task: task)
                        }
                    }
                    .onDelete(perform: vm.remove)
                }
            }
            .navigationTitle("Minhas Tarefas")
            .searchable(text: $search, placement: .navigationBarDrawer(displayMode: .always))
            .toolbar {
                ToolbarItem(placement: .topBarLeading) {
                    Button("Sobre") { showingAbout = true }
                }
                ToolbarItem(placement: .topBarTrailing) {
                    Button(role: .destructive) { confirmClear = true } label: {
                        Text("Apagar Todas")
                    }
                }
                ToolbarItem(placement: .bottomBar) {
                    Button { showingAdd = true } label: {
                        Label("Nova", systemImage: "plus")
                    }
                }
            }
            .confirmationDialog("Remover todas as tarefas?", isPresented: $confirmClear, titleVisibility: .visible) {
                Button("Remover todas", role: .destructive) { vm.removeAll() }
                Button("Cancelar", role: .cancel) {}
            } message: {
                Text("Esta ação não pode ser desfeita.")
            }
            .sheet(isPresented: $showingAdd) { AddEditTaskView() }
            .sheet(isPresented: $showingAbout) { AboutView() }
        }
    }
}

struct TaskRowView: View {
    let task: Task
    var body: some View {
        HStack(spacing: 12) {
            Image(systemName: task.imageName)
                .foregroundColor(task.category.color)
                .font(.system(size: 22))
                .frame(width: 28)
            VStack(alignment: .leading, spacing: 4) {
                Text(task.title).font(.headline)
                Text(task.description).font(.subheadline).foregroundColor(.secondary).lineLimit(2)
            }
            Spacer()
            Text(task.category.rawValue)
                .font(.caption).padding(.vertical, 4).padding(.horizontal, 8)
                .background(task.category.color.opacity(0.18))
                .clipShape(Capsule())
        }
        .padding(.vertical, 4)
    }
}

struct AddEditTaskView: View {
    @Environment(\.dismiss) private var dismiss
    @EnvironmentObject private var vm: TaskViewModel
    
    var existingTask: Task? = nil
    
    @State private var title = ""
    @State private var description = ""
    @State private var category: Category = .estudo
    @State private var imageName: String = "book.fill"
    
    private let symbols = ["book.fill","laptopcomputer","gamecontroller.fill","heart.fill","star","hammer.fill","cart.fill","tray.fill"]
    
    var body: some View {
        NavigationStack {
            Form {
                Section("Informações") {
                    TextField("Título", text: $title)
                    TextField("Descrição", text: $description, axis: .vertical)
                        .lineLimit(3...6)
                    Picker("Categoria", selection: $category) {
                        ForEach(Category.allCases) { cat in
                            Text(cat.rawValue).tag(cat)
                        }
                    }
                }
                Section("Ícone da Tarefa (SF Symbol)") {
                    ScrollView(.horizontal) {
                        HStack {
                            ForEach(symbols, id: \.self) { symbol in
                                VStack {
                                    Image(systemName: symbol).resizable().scaledToFit().frame(width: 36, height: 36)
                                        .foregroundStyle(category.color)
                                    Text(symbol).font(.caption2).lineLimit(1)
                                }
                                .padding(8)
                                .background(symbol == imageName ? Color.appPrimary.opacity(0.15) : Color.clear)
                                .clipShape(RoundedRectangle(cornerRadius: 8, style: .continuous))
                                .overlay(RoundedRectangle(cornerRadius: 8).stroke(symbol == imageName ? Color.appPrimary : .secondary.opacity(0.15)))
                                .onTapGesture { imageName = symbol }
                            }
                        }.padding(.horizontal, 4)
                    }
                }
            }
            .navigationTitle(existingTask == nil ? "Nova Tarefa" : "Editar Tarefa")
            .toolbar {
                ToolbarItem(placement: .confirmationAction) {
                    Button("Guardar") { save() }.disabled(title.trimmingCharacters(in: .whitespaces).isEmpty)
                }
                ToolbarItem(placement: .cancellationAction) {
                    Button("Cancelar") { dismiss() }
                }
            }
            .onAppear(perform: loadIfEditing)
        }
    }
    
    private func loadIfEditing() {
        guard let t = existingTask else { return }
        title = t.title; description = t.description; category = t.category; imageName = t.imageName
    }
    
    private func save() {
        let new = Task(id: existingTask?.id ?? UUID(), title: title, description: description, category: category, imageName: imageName)
        if existingTask == nil { vm.add(new) } else { vm.update(new) }
        dismiss()
    }
}

struct AboutView: View {
    var body: some View {
        VStack(spacing: 16) {
            AppLogoView()
            VStack(spacing: 8) {
                Text("Criadores: Ivan e colega")
                Text("Elementos extra: pesquisa, persistência local (UserDefaults), layout com gradiente")
                    .multilineTextAlignment(.center)
                Text("Autoavaliação: 19/20").font(.headline)
            }
            Spacer()
        }
        .padding()
    }
}
