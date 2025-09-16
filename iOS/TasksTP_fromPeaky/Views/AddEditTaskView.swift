import SwiftUI

struct AddEditTaskView: View {
    @Environment(\.dismiss) private var dismiss
    @EnvironmentObject private var vm: TaskViewModel

    var existing: TaskItem? = nil

    @State private var title = ""
    @State private var details = ""
    @State private var category: TaskCategory = .estudo
    @State private var imageName: String = "book.fill"

    private let symbols = ["book.fill","laptopcomputer","gamecontroller.fill","heart.fill","star",
                           "tray.fill","hammer.fill","cart.fill"]

    var body: some View {
        NavigationStack {
            Form {
                Section("Informações") {
                    TextField("Título", text: $title)
                    TextField("Descrição", text: $details, axis: .vertical).lineLimit(3...6)
                    Picker("Categoria", selection: $category) {
                        ForEach(TaskCategory.allCases) { c in
                            Text(c.rawValue).tag(c)
                        }
                    }
                }
                Section("Ícone da Tarefa (SF Symbol)") {
                    ScrollView(.horizontal) {
                        HStack {
                            ForEach(symbols, id: \.self) { symbol in
                                VStack {
                                    Image(systemName: symbol).resizable().scaledToFit()
                                        .frame(width: 36, height: 36)
                                        .foregroundStyle(category.color)
                                    Text(symbol).font(.caption2).lineLimit(1)
                                }
                                .padding(8)
                                .background(symbol == imageName ? Color.appPrimary.opacity(0.15) : Color.clear)
                                .clipShape(RoundedRectangle(cornerRadius: 8))
                                .overlay(RoundedRectangle(cornerRadius: 8)
                                    .stroke(symbol == imageName ? Color.appPrimary : .secondary.opacity(0.15)))
                                .onTapGesture { imageName = symbol }
                            }
                        }.padding(.horizontal, 4)
                    }
                }
            }
            .navigationTitle(existing == nil ? "Nova Tarefa" : "Editar Tarefa")
            .toolbar {
                ToolbarItem(placement: .confirmationAction) {
                    Button("Guardar") { save() }
                        .disabled(title.trimmingCharacters(in: .whitespaces).isEmpty)
                }
                ToolbarItem(placement: .cancellationAction) {
                    Button("Cancelar") { dismiss() }
                }
            }
            .onAppear(perform: loadIfEditing)
        }
    }

    private func loadIfEditing() {
        guard let t = existing else { return }
        title = t.title; details = t.details; category = t.category; imageName = t.imageName
    }

    private func save() {
        let new = TaskItem(id: existing?.id ?? UUID(),
                           title: title, details: details,
                           category: category, imageName: imageName)
        if existing == nil { vm.add(new) } else { vm.update(new) }
        dismiss()
    }
}

#Preview { AddEditTaskView().environmentObject(TaskViewModel()) }
