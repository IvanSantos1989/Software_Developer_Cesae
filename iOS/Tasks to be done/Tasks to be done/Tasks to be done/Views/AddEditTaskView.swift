//
//  AddEditTaskView.swift
//  Tasks to be done
//
//  Created by Developer on 18/09/2025.
//

import SwiftUI

struct AddEditTaskView: View {
    @ObservedObject var viewModel: TaskViewModel
    @Environment(\.presentationMode) var presentationMode
    
    // Task properties
    @State private var title: String = ""
    @State private var description: String = ""
    @State private var selectedCategory: TaskCategory = .personal
    @State private var selectedImage: TaskImage = .document
    @State private var selectedPriority: TaskPriority = .medium
    @State private var hasDueDate: Bool = false
    @State private var dueDate: Date = Date()
    
    // UI state
    @State private var showingImagePicker = false
    @State private var showingValidationError = false
    @State private var validationMessage = ""
    
    // Edit mode
    private let editingTask: TaskItem?
    private var isEditing: Bool { editingTask != nil }
    
    init(viewModel: TaskViewModel, editingTask: TaskItem? = nil) {
        self.viewModel = viewModel
        self.editingTask = editingTask
        
        if let task = editingTask {
            _title = State(initialValue: task.title)
            _description = State(initialValue: task.description)
            _selectedCategory = State(initialValue: task.category)
            _selectedImage = State(initialValue: task.imageName)
            _selectedPriority = State(initialValue: task.priority)
            _hasDueDate = State(initialValue: task.dueDate != nil)
            _dueDate = State(initialValue: task.dueDate ?? Date())
        }
    }
    
    var body: some View {
        NavigationView {
            ZStack {
                // Background
                Color(.systemGroupedBackground)
                    .ignoresSafeArea()
                
                ScrollView {
                    VStack(spacing: 20) {
                        // Header with preview
                        taskPreviewSection
                        
                        // Form sections
                        basicInfoSection
                        categorySection
                        imageSelectionSection
                        prioritySection
                        dueDateSection
                    }
                    .padding(.horizontal, 20)
                    .padding(.bottom, 30)
                }
            }
            .navigationTitle(isEditing ? "Editar Tarefa" : "Nova Tarefa")
            .navigationBarTitleDisplayMode(.inline)
            .navigationBarBackButtonHidden(true)
            .toolbar {
                ToolbarItem(placement: .navigationBarLeading) {
                    Button("Cancelar") {
                        presentationMode.wrappedValue.dismiss()
                    }
                }
                
                ToolbarItem(placement: .navigationBarTrailing) {
                    Button(isEditing ? "Atualizar" : "Adicionar") {
                        saveTask()
                    }
                    .fontWeight(.semibold)
                    .disabled(title.trimmingCharacters(in: .whitespacesAndNewlines).isEmpty)
                }
            }
            .alert("Erro de Validação", isPresented: $showingValidationError) {
                Button("OK", role: .cancel) { }
            } message: {
                Text(validationMessage)
            }
        }
    }
    
    // MARK: - Task Preview Section
    private var taskPreviewSection: some View {
        VStack(spacing: 16) {
            Text("Pré-visualização")
                .font(.headline)
                .frame(maxWidth: .infinity, alignment: .leading)
            
            // Task preview card
            VStack(alignment: .leading, spacing: 12) {
                HStack(spacing: 12) {
                    // Task icon
                    ZStack {
                        Circle()
                            .fill(colorForCategory(selectedCategory).opacity(0.2))
                            .frame(width: 50, height: 50)
                        
                        Image(systemName: selectedImage.rawValue)
                            .font(.system(size: 20, weight: .medium))
                            .foregroundColor(colorForCategory(selectedCategory))
                    }
                    
                    VStack(alignment: .leading, spacing: 4) {
                        Text(title.isEmpty ? "Título da tarefa" : title)
                            .font(.headline)
                            .foregroundColor(title.isEmpty ? .secondary : .primary)
                        
                        Text(description.isEmpty ? "Descrição da tarefa" : description)
                            .font(.subheadline)
                            .foregroundColor(description.isEmpty ? .secondary : .secondary)
                            .lineLimit(2)
                    }
                    
                    Spacer()
                }
                
                HStack {
                    // Category
                    HStack(spacing: 4) {
                        Image(systemName: selectedCategory.iconName)
                            .font(.system(size: 12))
                        Text(selectedCategory.rawValue)
                            .font(.caption)
                    }
                    .foregroundColor(colorForCategory(selectedCategory))
                    
                    Spacer()
                    
                    // Priority
                    HStack(spacing: 4) {
                        Image(systemName: selectedPriority.iconName)
                            .font(.system(size: 12))
                        Text(selectedPriority.rawValue)
                            .font(.caption)
                    }
                    .foregroundColor(colorForPriority(selectedPriority))
                    .padding(.horizontal, 8)
                    .padding(.vertical, 4)
                    .background(
                        Capsule()
                            .fill(colorForPriority(selectedPriority).opacity(0.1))
                    )
                }
            }
            .padding(16)
            .background(
                RoundedRectangle(cornerRadius: 12)
                    .fill(Color(.systemBackground))
                    .shadow(color: .black.opacity(0.05), radius: 2, x: 0, y: 1)
            )
        }
    }
    
    // MARK: - Basic Info Section
    private var basicInfoSection: some View {
        VStack(spacing: 16) {
            Text("Informações Básicas")
                .font(.headline)
                .frame(maxWidth: .infinity, alignment: .leading)
            
            VStack(spacing: 12) {
                // Title field
                VStack(alignment: .leading, spacing: 8) {
                    Text("Título *")
                        .font(.subheadline)
                        .fontWeight(.medium)
                    
                    TextField("Digite o título da tarefa", text: $title)
                        .textFieldStyle(RoundedBorderTextFieldStyle())
                }
                
                // Description field
                VStack(alignment: .leading, spacing: 8) {
                    Text("Descrição")
                        .font(.subheadline)
                        .fontWeight(.medium)
                    
                    ZStack(alignment: .topLeading) {
                        RoundedRectangle(cornerRadius: 8)
                            .stroke(Color(.systemGray4), lineWidth: 1)
                            .frame(height: 100)
                        
                        TextEditor(text: $description)
                            .padding(8)
                            .frame(height: 100)
                    }
                }
            }
            .padding(16)
            .background(
                RoundedRectangle(cornerRadius: 12)
                    .fill(Color(.systemBackground))
            )
        }
    }
    
    // MARK: - Category Section
    private var categorySection: some View {
        VStack(spacing: 16) {
            Text("Categoria")
                .font(.headline)
                .frame(maxWidth: .infinity, alignment: .leading)
            
            LazyVGrid(columns: Array(repeating: GridItem(.flexible()), count: 2), spacing: 12) {
                ForEach(TaskCategory.allCases) { category in
                    CategorySelectionCard(
                        category: category,
                        isSelected: selectedCategory == category,
                        action: { selectedCategory = category }
                    )
                }
            }
            .padding(16)
            .background(
                RoundedRectangle(cornerRadius: 12)
                    .fill(Color(.systemBackground))
            )
        }
    }
    
    // MARK: - Image Selection Section
    private var imageSelectionSection: some View {
        VStack(spacing: 16) {
            Text("Ícone da Tarefa")
                .font(.headline)
                .frame(maxWidth: .infinity, alignment: .leading)
            
            LazyVGrid(columns: Array(repeating: GridItem(.flexible()), count: 5), spacing: 12) {
                ForEach(TaskImage.allCases) { image in
                    ImageSelectionCard(
                        image: image,
                        isSelected: selectedImage == image,
                        category: selectedCategory,
                        action: { selectedImage = image }
                    )
                }
            }
            .padding(16)
            .background(
                RoundedRectangle(cornerRadius: 12)
                    .fill(Color(.systemBackground))
            )
        }
    }
    
    // MARK: - Priority Section
    private var prioritySection: some View {
        VStack(spacing: 16) {
            Text("Prioridade")
                .font(.headline)
                .frame(maxWidth: .infinity, alignment: .leading)
            
            HStack(spacing: 12) {
                ForEach(TaskPriority.allCases) { priority in
                    PrioritySelectionCard(
                        priority: priority,
                        isSelected: selectedPriority == priority,
                        action: { selectedPriority = priority }
                    )
                }
            }
            .padding(16)
            .background(
                RoundedRectangle(cornerRadius: 12)
                    .fill(Color(.systemBackground))
            )
        }
    }
    
    // MARK: - Due Date Section
    private var dueDateSection: some View {
        VStack(spacing: 16) {
            Text("Data Limite")
                .font(.headline)
                .frame(maxWidth: .infinity, alignment: .leading)
            
            VStack(spacing: 12) {
                // Toggle for due date
                HStack {
                    Text("Definir data limite")
                        .font(.subheadline)
                    
                    Spacer()
                    
                    Toggle("", isOn: $hasDueDate)
                        .toggleStyle(SwitchToggleStyle())
                }
                
                // Date picker (shown when toggle is on)
                if hasDueDate {
                    DatePicker(
                        "Data limite",
                        selection: $dueDate,
                        in: Date()...,
                        displayedComponents: [.date, .hourAndMinute]
                    )
                    .datePickerStyle(WheelDatePickerStyle())
                }
            }
            .padding(16)
            .background(
                RoundedRectangle(cornerRadius: 12)
                    .fill(Color(.systemBackground))
            )
        }
    }
    
    // MARK: - Helper Methods
    private func saveTask() {
        // Validation
        let trimmedTitle = title.trimmingCharacters(in: .whitespacesAndNewlines)
        
        if trimmedTitle.isEmpty {
            validationMessage = "O título da tarefa é obrigatório."
            showingValidationError = true
            return
        }
        
        if trimmedTitle.count < 3 {
            validationMessage = "O título deve ter pelo menos 3 caracteres."
            showingValidationError = true
            return
        }
        
        // Create or update task
        if let editingTask = editingTask {
            // Update existing task
            var updatedTask = editingTask
            updatedTask.title = trimmedTitle
            updatedTask.description = description.trimmingCharacters(in: .whitespacesAndNewlines)
            updatedTask.category = selectedCategory
            updatedTask.imageName = selectedImage
            updatedTask.priority = selectedPriority
            updatedTask.dueDate = hasDueDate ? dueDate : nil
            
            viewModel.updateTask(updatedTask)
        } else {
            // Create new task
            let newTask = TaskItem(
                title: trimmedTitle,
                description: description.trimmingCharacters(in: .whitespacesAndNewlines),
                category: selectedCategory,
                imageName: selectedImage,
                priority: selectedPriority,
                dueDate: hasDueDate ? dueDate : nil
            )
            
            viewModel.addTask(newTask)
        }
        
        presentationMode.wrappedValue.dismiss()
    }
    
    private func colorForCategory(_ category: TaskCategory) -> Color {
        switch category {
        case .work: return .blue
        case .personal: return .green
        case .shopping: return .orange
        case .health: return .red
        case .education: return .purple
        }
    }
    
    private func colorForPriority(_ priority: TaskPriority) -> Color {
        switch priority {
        case .low: return .green
        case .medium: return .orange
        case .high: return .red
        }
    }
}

// MARK: - Supporting Views
struct CategorySelectionCard: View {
    let category: TaskCategory
    let isSelected: Bool
    let action: () -> Void
    
    var body: some View {
        Button(action: action) {
            VStack(spacing: 8) {
                ZStack {
                    Circle()
                        .fill(colorForCategory.opacity(0.2))
                        .frame(width: 40, height: 40)
                    
                    Image(systemName: category.iconName)
                        .font(.system(size: 18, weight: .medium))
                        .foregroundColor(colorForCategory)
                }
                
                Text(category.rawValue)
                    .font(.caption)
                    .fontWeight(.medium)
                    .multilineTextAlignment(.center)
            }
            .foregroundColor(isSelected ? .white : .primary)
            .frame(maxWidth: .infinity)
            .padding(.vertical, 12)
            .background(
                RoundedRectangle(cornerRadius: 8)
                    .fill(isSelected ? colorForCategory : Color(.systemGray6))
            )
            .overlay(
                RoundedRectangle(cornerRadius: 8)
                    .stroke(isSelected ? colorForCategory : Color.clear, lineWidth: 2)
            )
        }
        .buttonStyle(PlainButtonStyle())
    }
    
    private var colorForCategory: Color {
        switch category {
        case .work: return .blue
        case .personal: return .green
        case .shopping: return .orange
        case .health: return .red
        case .education: return .purple
        }
    }
}

struct ImageSelectionCard: View {
    let image: TaskImage
    let isSelected: Bool
    let category: TaskCategory
    let action: () -> Void
    
    var body: some View {
        Button(action: action) {
            VStack(spacing: 4) {
                Image(systemName: image.rawValue)
                    .font(.system(size: 20, weight: .medium))
                    .foregroundColor(isSelected ? .white : colorForCategory)
                    .frame(width: 40, height: 40)
                
                Text(image.displayName)
                    .font(.caption2)
                    .lineLimit(1)
                    .foregroundColor(isSelected ? .white : .secondary)
            }
            .frame(maxWidth: .infinity)
            .padding(.vertical, 8)
            .background(
                RoundedRectangle(cornerRadius: 8)
                    .fill(isSelected ? colorForCategory : Color(.systemGray6))
            )
        }
        .buttonStyle(PlainButtonStyle())
    }
    
    private var colorForCategory: Color {
        switch category {
        case .work: return .blue
        case .personal: return .green
        case .shopping: return .orange
        case .health: return .red
        case .education: return .purple
        }
    }
}

struct PrioritySelectionCard: View {
    let priority: TaskPriority
    let isSelected: Bool
    let action: () -> Void
    
    var body: some View {
        Button(action: action) {
            VStack(spacing: 6) {
                Image(systemName: priority.iconName)
                    .font(.system(size: 18, weight: .medium))
                    .foregroundColor(isSelected ? .white : colorForPriority)
                
                Text(priority.rawValue)
                    .font(.caption)
                    .fontWeight(.medium)
            }
            .foregroundColor(isSelected ? .white : .primary)
            .frame(maxWidth: .infinity)
            .padding(.vertical, 12)
            .background(
                RoundedRectangle(cornerRadius: 8)
                    .fill(isSelected ? colorForPriority : Color(.systemGray6))
            )
        }
        .buttonStyle(PlainButtonStyle())
    }
    
    private var colorForPriority: Color {
        switch priority {
        case .low: return .green
        case .medium: return .orange
        case .high: return .red
        }
    }
}

#Preview("Add Task") {
    AddEditTaskView(viewModel: TaskViewModel())
}

#Preview("Edit Task") {
    AddEditTaskView(viewModel: TaskViewModel(), editingTask: TaskItem.sampleTasks[0])
}