import SwiftUI

@main
struct ToDoList_TP_CompleteApp: App {
    @StateObject private var vm = TaskViewModel()
    var body: some Scene {
        WindowGroup {
            ContentView()
                .environmentObject(vm)
        }
    }
}
