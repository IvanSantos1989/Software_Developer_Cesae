import Foundation

final class TaskViewModel: ObservableObject {
    @Published var tasks: [Task] = [] {
        didSet { persist() }
    }
    private let storageKey = "tp.todo.tasks"
    
    init() {
        restore()
    }
    
    func add(_ task: Task) { tasks.append(task) }
    func update(_ task: Task) {
        guard let i = tasks.firstIndex(where: { $0.id == task.id }) else { return }
        tasks[i] = task
    }
    func remove(at offsets: IndexSet) { tasks.remove(atOffsets: offsets) }
    func removeAll() { tasks.removeAll() }
    
    private func persist() {
        if let data = try? JSONEncoder().encode(tasks) {
            UserDefaults.standard.set(data, forKey: storageKey)
        }
    }
    private func restore() {
        guard let data = UserDefaults.standard.data(forKey: storageKey),
              let decoded = try? JSONDecoder().decode([Task].self, from: data) else { return }
        tasks = decoded
    }
}
