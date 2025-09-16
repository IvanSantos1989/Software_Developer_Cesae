import Foundation

final class TaskViewModel: ObservableObject {
    @Published var tasks: [TaskItem] = [] { didSet { persist() } }
    private let storageKey = "tp.tasks.storage"
    
    init() { restore() }
    
    func add(_ t: TaskItem) { tasks.append(t) }
    func update(_ t: TaskItem) {
        guard let i = tasks.firstIndex(where: { $0.id == t.id }) else { return }
        tasks[i] = t
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
              let decoded = try? JSONDecoder().decode([TaskItem].self, from: data) else { return }
        tasks = decoded
    }
}
