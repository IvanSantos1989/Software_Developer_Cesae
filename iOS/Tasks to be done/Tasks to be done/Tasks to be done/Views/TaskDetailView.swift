//
//  TaskDetailView.swift
//  Tasks to be done
//
//  Created by Developer on 18/09/2025.
//

import SwiftUI

struct TaskDetailView: View {
    let task: TaskItem
    @ObservedObject var viewModel: TaskViewModel
    @Environment(\.presentationMode) var presentationMode
    
    @State private var showingEditSheet = false
    @State private var showingDeleteAlert = false
    
    var body: some View {
        ZStack {
            // Background gradient
            LinearGradient(
                gradient: Gradient(colors: [
                    colorForCategory(task.category).opacity(0.1),
                    Color(.systemBackground)
                ]),
                startPoint: .top,
                endPoint: .bottom
            )
            .ignoresSafeArea()
            
            ScrollView {
                VStack(spacing: 24) {
                    // Header section
                    headerSection
                    
                    // Task content
                    taskContentSection
                    
                    // Task metadata
                    metadataSection
                    
                    // Action buttons
                    actionButtonsSection
                }
                .padding(.horizontal, 20)
                .padding(.bottom, 30)
            }
        }
        .navigationTitle("Detalhes")
        .navigationBarTitleDisplayMode(.inline)
        .toolbar {
            ToolbarItem(placement: .navigationBarTrailing) {
                Menu {
                    Button(action: { showingEditSheet = true }) {
                        Label("Editar", systemImage: "pencil")
                    }
                    
                    Button(action: { 
                        viewModel.toggleTaskCompletion(task)
                        presentationMode.wrappedValue.dismiss()
                    }) {
                        Label(
                            task.isCompleted ? "Marcar como pendente" : "Marcar como concluída",
                            systemImage: task.isCompleted ? "arrow.uturn.backward" : "checkmark"
                        )
                    }
                    
                    Divider()
                    
                    Button(role: .destructive, action: { showingDeleteAlert = true }) {
                        Label("Eliminar", systemImage: "trash")
                    }
                } label: {
                    Image(systemName: "ellipsis.circle")
                        .font(.title2)
                }
            }
        }
        .sheet(isPresented: $showingEditSheet) {
            AddEditTaskView(viewModel: viewModel, editingTask: task)
        }
        .alert("Eliminar Tarefa", isPresented: $showingDeleteAlert) {
            Button("Cancelar", role: .cancel) { }
            Button("Eliminar", role: .destructive) {
                viewModel.deleteTask(task)
                presentationMode.wrappedValue.dismiss()
            }
        } message: {
            Text("Tem certeza que deseja eliminar esta tarefa? Esta ação não pode ser desfeita.")
        }
    }
    
    // MARK: - Header Section
    private var headerSection: some View {
        VStack(spacing: 20) {
            // Task icon and title
            VStack(spacing: 16) {
                ZStack {
                    Circle()
                        .fill(colorForCategory(task.category).opacity(0.2))
                        .frame(width: 100, height: 100)
                    
                    Image(systemName: task.imageName.rawValue)
                        .font(.system(size: 40, weight: .medium))
                        .foregroundColor(colorForCategory(task.category))
                    
                    // Completion indicator
                    if task.isCompleted {
                        VStack {
                            Spacer()
                            HStack {
                                Spacer()
                                ZStack {
                                    Circle()
                                        .fill(Color.green)
                                        .frame(width: 30, height: 30)
                                    
                                    Image(systemName: "checkmark")
                                        .font(.system(size: 16, weight: .bold))
                                        .foregroundColor(.white)
                                }
                                .offset(x: 10, y: 10)
                            }
                        }
                        .frame(width: 100, height: 100)
                    }
                }
                
                VStack(spacing: 8) {
                    Text(task.title)
                        .font(.title2)
                        .fontWeight(.bold)
                        .multilineTextAlignment(.center)
                        .foregroundColor(task.isCompleted ? .secondary : .primary)
                        .strikethrough(task.isCompleted)
                    
                    // Status badge
                    HStack {
                        Image(systemName: task.isCompleted ? "checkmark.circle.fill" : "clock")
                            .font(.caption)
                        
                        Text(task.isCompleted ? "Concluída" : "Pendente")
                            .font(.caption)
                            .fontWeight(.medium)
                    }
                    .foregroundColor(task.isCompleted ? .green : .orange)
                    .padding(.horizontal, 12)
                    .padding(.vertical, 4)
                    .background(
                        Capsule()
                            .fill((task.isCompleted ? Color.green : Color.orange).opacity(0.1))
                    )
                }
            }
        }
        .padding(.top, 20)
    }
    
    // MARK: - Task Content Section
    private var taskContentSection: some View {
        VStack(spacing: 16) {
            // Description
            if !task.description.isEmpty {
                VStack(alignment: .leading, spacing: 8) {
                    Text("Descrição")
                        .font(.headline)
                        .foregroundColor(.primary)
                    
                    Text(task.description)
                        .font(.body)
                        .foregroundColor(task.isCompleted ? .secondary : .primary)
                        .strikethrough(task.isCompleted)
                        .padding(16)
                        .frame(maxWidth: .infinity, alignment: .leading)
                        .background(
                            RoundedRectangle(cornerRadius: 12)
                                .fill(Color(.systemGray6))
                        )
                }
            }
        }
    }
    
    // MARK: - Metadata Section
    private var metadataSection: some View {
        VStack(spacing: 16) {
            Text("Informações")
                .font(.headline)
                .frame(maxWidth: .infinity, alignment: .leading)
            
            VStack(spacing: 12) {
                // Category
                MetadataRow(
                    icon: task.category.iconName,
                    title: "Categoria",
                    value: task.category.rawValue,
                    color: colorForCategory(task.category)
                )
                
                Divider()
                
                // Priority
                MetadataRow(
                    icon: task.priority.iconName,
                    title: "Prioridade",
                    value: task.priority.rawValue,
                    color: colorForPriority(task.priority)
                )
                
                Divider()
                
                // Created date
                MetadataRow(
                    icon: "calendar.badge.plus",
                    title: "Criada em",
                    value: formatDate(task.createdDate),
                    color: .blue
                )
                
                // Due date
                if let dueDate = task.dueDate {
                    Divider()
                    
                    MetadataRow(
                        icon: "calendar.badge.exclamationmark",
                        title: "Data limite",
                        value: formatDate(dueDate),
                        color: isOverdue(dueDate) ? .red : .orange
                    )
                }
                
                // Completed date
                if let completedDate = task.completedDate {
                    Divider()
                    
                    MetadataRow(
                        icon: "calendar.badge.checkmark",
                        title: "Concluída em",
                        value: formatDate(completedDate),
                        color: .green
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
    
    // MARK: - Action Buttons Section
    private var actionButtonsSection: some View {
        VStack(spacing: 12) {
            // Toggle completion button
            Button(action: {
                viewModel.toggleTaskCompletion(task)
                presentationMode.wrappedValue.dismiss()
            }) {
                HStack {
                    Image(systemName: task.isCompleted ? "arrow.uturn.backward" : "checkmark")
                        .font(.title3)
                    
                    Text(task.isCompleted ? "Marcar como Pendente" : "Marcar como Concluída")
                        .font(.headline)
                        .fontWeight(.medium)
                }
                .foregroundColor(.white)
                .frame(maxWidth: .infinity)
                .padding(.vertical, 16)
                .background(
                    RoundedRectangle(cornerRadius: 12)
                        .fill(task.isCompleted ? Color.orange : Color.green)
                )
            }
            
            HStack(spacing: 12) {
                // Edit button
                Button(action: { showingEditSheet = true }) {
                    HStack {
                        Image(systemName: "pencil")
                            .font(.title3)
                        
                        Text("Editar")
                            .font(.headline)
                            .fontWeight(.medium)
                    }
                    .foregroundColor(.blue)
                    .frame(maxWidth: .infinity)
                    .padding(.vertical, 16)
                    .background(
                        RoundedRectangle(cornerRadius: 12)
                            .stroke(Color.blue, lineWidth: 2)
                    )
                }
                
                // Delete button
                Button(action: { showingDeleteAlert = true }) {
                    HStack {
                        Image(systemName: "trash")
                            .font(.title3)
                        
                        Text("Eliminar")
                            .font(.headline)
                            .fontWeight(.medium)
                    }
                    .foregroundColor(.red)
                    .frame(maxWidth: .infinity)
                    .padding(.vertical, 16)
                    .background(
                        RoundedRectangle(cornerRadius: 12)
                            .stroke(Color.red, lineWidth: 2)
                    )
                }
            }
        }
    }
    
    // MARK: - Helper Methods
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
    
    private func formatDate(_ date: Date) -> String {
        let formatter = DateFormatter()
        formatter.dateStyle = .medium
        formatter.timeStyle = .short
        formatter.locale = Locale(identifier: "pt_PT")
        return formatter.string(from: date)
    }
    
    private func isOverdue(_ date: Date) -> Bool {
        return date < Date() && !task.isCompleted
    }
}

// MARK: - Supporting Views
struct MetadataRow: View {
    let icon: String
    let title: String
    let value: String
    let color: Color
    
    var body: some View {
        HStack(spacing: 12) {
            Image(systemName: icon)
                .font(.title3)
                .foregroundColor(color)
                .frame(width: 24)
            
            VStack(alignment: .leading, spacing: 2) {
                Text(title)
                    .font(.caption)
                    .foregroundColor(.secondary)
                
                Text(value)
                    .font(.subheadline)
                    .fontWeight(.medium)
                    .foregroundColor(.primary)
            }
            
            Spacer()
        }
    }
}

#Preview("Task Detail") {
    NavigationView {
        TaskDetailView(task: TaskItem.sampleTasks[0], viewModel: TaskViewModel())
    }
}

#Preview("Completed Task Detail") {
    NavigationView {
        let task = TaskItem.sampleTasks[0]
        var completedTask = task
        completedTask.isCompleted = true
        completedTask.completedDate = Date()
        
        return TaskDetailView(task: completedTask, viewModel: TaskViewModel())
    }
}