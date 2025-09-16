import SwiftUI

// MARK: - THEME
extension Color {
    static let appPrimary = Color(red: 0.12, green: 0.43, blue: 0.95)
    static let appSecondary = Color(red: 0.92, green: 0.96, blue: 1.0)
}

struct AppLogoView: View {
    var body: some View {
        ZStack {
            Circle()
                .fill(LinearGradient(colors: [.appPrimary, .blue.opacity(0.7)],
                                     startPoint: .topLeading, endPoint: .bottomTrailing))
                .frame(width: 120, height: 120)
                .shadow(radius: 8)
            Image(systemName: "checkmark.seal.fill")
                .font(.system(size: 54, weight: .bold))
                .foregroundColor(.white)
                .shadow(radius: 2)
        }
        .overlay(
            Text("ToDoApp")
                .font(.headline)
                .foregroundColor(.appPrimary)
                .padding(.top, 140),
            alignment: .top
        )
        .padding(.vertical)
    }
}

// MARK: - MODEL
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

// MARK: - VIEWMODEL
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

// MARK: - MAIN VIEW
struct ContentView: View {
    @StateObject var vm = TaskViewModel()
    @State private var showingAdd = false
    @State private var showingAbout = false
    
    var body: some View {
        NavigationStack {
            List {
                Section {
                    AppLogoView()
                        .frame(maxWidth: .infinity)
                        .listRowInsets(EdgeInsets())
                        .background(Color.appSecondary)
                }
                ForEach(vm.tasks) { task in
                    NavigationLink(destination: AddEditTaskView(vm: vm, existingTask: task)) {
                        HStack {
                            Image(systemName: task.imageName)
                                .foregroundColor(task.category.color)
                                .font(.system(size: 22))
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

// MARK: - ADD / EDIT VIEW
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

// MARK: - ABOUT VIEW
struct AboutView: View {
    var body: some View {
        VStack(spacing: 20) {
            AppLogoView()
            Text("ToDoApp")
                .font(.title2)
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

// MARK: - APP ENTRY
@main
struct ToDoAppSwiftUIApp: App {
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
