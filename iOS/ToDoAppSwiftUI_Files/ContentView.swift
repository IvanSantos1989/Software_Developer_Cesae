import SwiftUI

struct Task: Identifiable, Codable, Equatable {
    var id = UUID()
    var title: String
    var description: String
    var category: Category
    var imageName: String
}

enum Category: String, CaseIterable, Codable, Identifiable {
    case estudo = "Estudo"
    case trabalho = "Trabalho"
    case lazer = "Lazer"
    case saude = "Saúde"
    case outros = "Outros"
    
    var id: String { self.rawValue }
    var color: Color {
        switch self {
        case .estudo: return .blue
        case .trabalho: return .orange
        case .lazer: return .green
        case .saude: return .pink
        case .outros: return .gray
        }
    }
}

class TaskViewModel: ObservableObject {
    @Published var tasks: [Task] = []
    
    func add(task: Task) { tasks.append(task) }
    func update(task: Task) {
        if let i = tasks.firstIndex(where: { $0.id == task.id }) {
            tasks[i] = task
        }
    }
    func remove(at offsets: IndexSet) { tasks.remove(atOffsets: offsets) }
    func removeAll() { tasks.removeAll() }
}

struct ContentView: View {
    @StateObject var vm = TaskViewModel()
    @State private var showingAdd = false
    @State private var showingAbout = false
    
    var body: some View {
        NavigationStack {
            List {
                ForEach(vm.tasks) { task in
                    NavigationLink(destination: AddEditTaskView(vm: vm, existingTask: task)) {
                        HStack {
                            Image(systemName: task.imageName)
                                .foregroundColor(task.category.color)
                                .frame(width: 30)
                            VStack(alignment: .leading) {
                                Text(task.title).font(.headline)
                                Text(task.description).font(.subheadline).foregroundColor(.secondary)
                            }
                            Spacer()
                            Text(task.category.rawValue)
                                .padding(6)
                                .background(task.category.color.opacity(0.2))
                                .cornerRadius(6)
                        }
                    }
                }
                .onDelete(perform: vm.remove)
            }
            .navigationTitle("Minhas Tarefas")
            .toolbar {
                ToolbarItem(placement: .topBarLeading) {
                    Button("Sobre") { showingAbout = true }
                }
                ToolbarItem(placement: .topBarTrailing) {
                    Button("Apagar Todas") { vm.removeAll() }
                }
                ToolbarItem(placement: .bottomBar) {
                    Button(action: { showingAdd = true }) {
                        Label("Nova", systemImage: "plus")
                    }
                }
            }
            .sheet(isPresented: $showingAdd) { AddEditTaskView(vm: vm) }
            .sheet(isPresented: $showingAbout) { AboutView() }
        }
    }
}

struct AddEditTaskView: View {
    @Environment(\.dismiss) var dismiss
    @ObservedObject var vm: TaskViewModel
    var existingTask: Task? = nil
    
    @State private var title = ""
    @State private var description = ""
    @State private var category = Category.estudo
    @State private var imageName = "star"
    
    let symbols = ["book.fill","laptopcomputer","gamecontroller.fill","heart.fill","star"]
    
    var body: some View {
        NavigationStack {
            Form {
                Section("Informações") {
                    TextField("Título", text: $title)
                    TextField("Descrição", text: $description)
                    Picker("Categoria", selection: $category) {
                        ForEach(Category.allCases) { cat in
                            Text(cat.rawValue).tag(cat)
                        }
                    }
                }
                Section("Ícone") {
                    ScrollView(.horizontal) {
                        HStack {
                            ForEach(symbols, id: \.self) { symbol in
                                Image(systemName: symbol)
                                    .resizable()
                                    .frame(width: 40, height: 40)
                                    .padding()
                                    .background(symbol == imageName ? Color.blue.opacity(0.2) : Color.clear)
                                    .cornerRadius(8)
                                    .onTapGesture { imageName = symbol }
                            }
                        }
                    }
                }
            }
            .navigationTitle(existingTask == nil ? "Nova Tarefa" : "Editar Tarefa")
            .toolbar {
                ToolbarItem(placement: .confirmationAction) {
                    Button("Guardar") {
                        let newTask = Task(id: existingTask?.id ?? UUID(), title: title, description: description, category: category, imageName: imageName)
                        if existingTask == nil { vm.add(task: newTask) } else { vm.update(task: newTask) }
                        dismiss()
                    }
                }
                ToolbarItem(placement: .cancellationAction) {
                    Button("Cancelar") { dismiss() }
                }
            }
            .onAppear {
                if let t = existingTask {
                    title = t.title
                    description = t.description
                    category = t.category
                    imageName = t.imageName
                }
            }
        }
    }
}

struct AboutView: View {
    var body: some View {
        VStack(spacing: 20) {
            Image(systemName: "checkmark.seal.fill")
                .font(.system(size: 60))
                .foregroundColor(.blue)
            Text("ToDoApp")
                .font(.largeTitle)
            Text("Criado por: Ivan e colega")
            Text("Extras: layout customizado, categorias coloridas, remoção em massa, SF Symbols")
                .multilineTextAlignment(.center)
            Text("Autoavaliação: 19/20")
                .font(.headline)
                .padding(.top)
            Spacer()
        }
        .padding()
    }
}

@main
struct ToDoAppSwiftUIApp: App {
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
