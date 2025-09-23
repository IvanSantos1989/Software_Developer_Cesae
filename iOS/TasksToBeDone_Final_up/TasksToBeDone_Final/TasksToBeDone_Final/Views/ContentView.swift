import SwiftUI

struct ContentView: View {
    @EnvironmentObject var vm: TaskViewModel
    @State private var showingAdd = false
    @State private var showingAbout = false
    @State private var confirmClear = false
    @State private var search = ""

    var filtered: [TaskItem] {
        let s = search.trimmingCharacters(in: .whitespacesAndNewlines)
        if s.isEmpty { return vm.tasks }
        return vm.tasks.filter {
            $0.title.localizedCaseInsensitiveContains(s) ||
            $0.details.localizedCaseInsensitiveContains(s) ||
            $0.category.rawValue.localizedCaseInsensitiveContains(s)
        }
    }

    var body: some View {
        NavigationStack {
            List {
                Section { AppLogoView().listRowInsets(EdgeInsets()) }
                    .listRowBackground(Color.appSecondary)

                if filtered.isEmpty {
                    
                    #if os(iOS)
                    if #available(iOS 17.0, *) {
                        ContentUnavailableView(
                            "Sem tarefas",
                            systemImage: "tray",
                            description: Text("Toque em **Nova** para adicionar uma tarefa.")
                        )
                        .frame(maxWidth: .infinity, alignment: .center)
                        .listRowBackground(Color.clear)
                    } else {
                        VStack(spacing: 8) {
                            Image(systemName: "tray")
                                .font(.largeTitle)
                            Text("Sem tarefas")
                                .font(.headline)
                            Text("Toque em Nova para adicionar uma tarefa.")
                                .font(.subheadline)
                                .foregroundStyle(.secondary)
                        }
                        .frame(maxWidth: .infinity, alignment: .center)
                        .listRowBackground(Color.clear)
                    }
                    #else
                    VStack(spacing: 8) {
                        Image(systemName: "tray").font(.largeTitle)
                        Text("Sem tarefas").font(.headline)
                        Text("Use o botão para adicionar uma tarefa.").font(.subheadline).foregroundStyle(.secondary)
                    }
                    .frame(maxWidth: .infinity, alignment: .center)
                    .listRowBackground(Color.clear)
                    #endif
                } else {
                    ForEach(filtered) { t in
                        NavigationLink {
                            AddEditTaskView(existing: t)
                        } label: {
                            TaskRowView(task: t)
                        }
                    }
                    .onDelete(perform: vm.remove)
                }
            }
            .navigationTitle("Minhas Tarefas")

            
            #if os(iOS)
            .searchable(text: $search, placement: .navigationBarDrawer(displayMode: .always))
            .toolbar {
                ToolbarItem(placement: .topBarLeading) {
                    Button("Sobre") { showingAbout = true }
                }
                ToolbarItem(placement: .topBarTrailing) {
                    Button(role: .destructive) { confirmClear = true } label: { Text("Apagar Todas") }
                }
                ToolbarItem(placement: .bottomBar) {
                    Button { showingAdd = true } label: { Label("Nova", systemImage: "plus") }
                }
            }
            #else
            .searchable(text: $search)
            .toolbar {
                Button("Sobre") { showingAbout = true }
                Button("Apagar Todas", role: .destructive) { confirmClear = true }
                Button { showingAdd = true } label: { Label("Nova", systemImage: "plus") }
            }
            #endif

            .confirmationDialog(
                "Remover todas as tarefas?",
                isPresented: $confirmClear,
                titleVisibility: .visible
            ) {
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
    @EnvironmentObject var vm: TaskViewModel
    let task: TaskItem

    var body: some View {
        HStack(spacing: 12) {
            Image(systemName: task.imageName)
                .foregroundStyle(task.category.color)
                .font(.system(size: 22))
                .frame(width: 28)

            VStack(alignment: .leading, spacing: 4) {
                Text(task.title).font(.headline)
                Text(task.details)
                    .font(.subheadline)
                    .foregroundStyle(.secondary)
                    .lineLimit(2)
            }

            Spacer()

            // Categoria como cápsula
            Text(task.category.rawValue)
                .font(.caption)
                .padding(.vertical, 4)
                .padding(.horizontal, 8)
                .background(task.category.color.opacity(0.18))
                .clipShape(Capsule())

            // Botão para apagar somente esta tarefa
            Button(role: .destructive) {
                if let index = vm.tasks.firstIndex(of: task) {
                    vm.tasks.remove(at: index)
                }
            } label: {
                Image(systemName: "trash")
            }
            .buttonStyle(.borderless)
        }
        .padding(.vertical, 4)
    }
}
