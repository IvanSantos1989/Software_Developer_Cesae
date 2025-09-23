import SwiftUI

@main
struct TasksToBeDone_FinalApp: App {
    @StateObject private var vm = TaskViewModel()
    var body: some Scene {
        WindowGroup {
            ContentView()
                .environmentObject(vm)
        }
    }
}
