import Foundation

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
