//
//  ContentView.swift
//  Tasks to be done
//
//  Created by MultiLab PRT 13 on 16/09/2025.
//

import SwiftUI

struct ContentView: View {
    @StateObject private var viewModel = TaskViewModel()
    @State private var showingAddTask = false
    @State private var showingAbout = false
    @State private var showingDeleteAlert = false
    @State private var selectedTask: TaskItem?
    
    var body: some View {
        NavigationView {
            ZStack {
                // Background gradient
                LinearGradient(
                    gradient: Gradient(colors: [
                        Color(.systemGroupedBackground),
                        Color(.systemBackground)
                    ]),
                    startPoint: .top,
                    endPoint: .bottom
                )
                .ignoresSafeArea()
                
                VStack(spacing: 0) {
                    // Header with logo and stats
                    headerView
                    
                    // Search and filter section
                    searchAndFilterSection
                    
                    // Tasks list
                    tasksListView
                }
            }
            .navigationTitle("")
            .navigationBarHidden(true)
            .sheet(isPresented: $showingAddTask) {
                AddEditTaskView(viewModel: viewModel)
            }
            .sheet(isPresented: $showingAbout) {
                AboutView()
            }
            .alert("Eliminar Todas as Tarefas", isPresented: $showingDeleteAlert) {
                Button("Cancelar", role: .cancel) { }
                Button("Eliminar", role: .destructive) {
                    viewModel.deleteAllTasks()
                }
            } message: {
                Text("Tem certeza que deseja eliminar todas as tarefas? Esta ação não pode ser desfeita.")
            }
        }
        .navigationViewStyle(StackNavigationViewStyle())
    }
    
    // MARK: - Header View
    private var headerView: some View {
        VStack(spacing: 16) {
            HStack {
                HeaderLogoView()
                
                Spacer()
                
                HStack(spacing: 12) {
                    // About button
                    Button(action: { showingAbout = true }) {
                        Image(systemName: "info.circle")
                            .font(.title2)
                            .foregroundColor(.blue)
                    }
                    
                    // Add task button
                    Button(action: { showingAddTask = true }) {
                        ZStack {
                            Circle()
                                .fill(Color.blue)
                                .frame(width: 40, height: 40)
                            
                            Image(systemName: "plus")
                                .font(.title2)
                                .fontWeight(.semibold)
                                .foregroundColor(.white)
                        }
                    }
                }
            }
            
            // Statistics cards
            statsCardsView
        }
        .padding(.horizontal, 20)
        .padding(.top, 10)
    }
    
    // MARK: - Stats Cards
    private var statsCardsView: some View {
        HStack(spacing: 12) {
            StatCardView(
                title: "Total",
                value: "\(viewModel.totalTasksCount)",
                icon: "list.bullet",
                color: .blue
            )
            
            StatCardView(
                title: "Pendentes",
                value: "\(viewModel.pendingTasksCount)",
                icon: "clock",
                color: .orange
            )
            
            StatCardView(
                title: "Concluídas",
                value: "\(viewModel.completedTasksCount)",
                icon: "checkmark.circle",
                color: .green
            )
        }
    }
    
    // MARK: - Search and Filter Section
    private var searchAndFilterSection: some View {
        VStack(spacing: 12) {
            // Search bar
            HStack {
                Image(systemName: "magnifyingglass")
                    .foregroundColor(.secondary)
                
                TextField("Procurar tarefas...", text: $viewModel.searchText)
                    .textFieldStyle(PlainTextFieldStyle())
                
                if !viewModel.searchText.isEmpty {
                    Button(action: { viewModel.searchText = "" }) {
                        Image(systemName: "xmark.circle.fill")
                            .foregroundColor(.secondary)
                    }
                }
            }
            .padding(.horizontal, 12)
            .padding(.vertical, 8)
            .background(
                RoundedRectangle(cornerRadius: 10)
                    .fill(Color(.systemGray6))
            )
            
            // Category filter
            ScrollView(.horizontal, showsIndicators: false) {
                HStack(spacing: 8) {
                    CategoryFilterButton(
                        title: "Todas",
                        isSelected: viewModel.selectedCategory == nil,
                        action: { viewModel.setCategory(nil) }
                    )
                    
                    ForEach(TaskCategory.allCases) { category in
                        CategoryFilterButton(
                            title: category.rawValue,
                            icon: category.iconName,
                            isSelected: viewModel.selectedCategory == category,
                            action: { viewModel.setCategory(category) }
                        )
                    }
                }
                .padding(.horizontal, 20)
            }
        }
        .padding(.horizontal, 20)
        .padding(.vertical, 12)
    }
    
    // MARK: - Tasks List View
    private var tasksListView: some View {
        VStack(spacing: 0) {
            if viewModel.filteredTasks.isEmpty {
                emptyStateView
            } else {
                // Action buttons
                actionButtonsView
                
                // Tasks list
                ScrollView {
                    LazyVStack(spacing: 12) {
                        ForEach(viewModel.filteredTasks) { task in
                            NavigationLink(
                                destination: TaskDetailView(task: task, viewModel: viewModel)
                            ) {
                                TaskRowView(task: task) {
                                    viewModel.toggleTaskCompletion(task)
                                }
                            }
                            .buttonStyle(PlainButtonStyle())
                        }
                    }
                    .padding(.horizontal, 20)
                    .padding(.bottom, 20)
                }
            }
        }
    }
    
    // MARK: - Empty State
    private var emptyStateView: some View {
        VStack(spacing: 20) {
            Spacer()
            
            ZStack {
                Circle()
                    .fill(Color.blue.opacity(0.1))
                    .frame(width: 100, height: 100)
                
                Image(systemName: "tray")
                    .font(.system(size: 40))
                    .foregroundColor(.blue)
            }
            
            VStack(spacing: 8) {
                Text("Nenhuma tarefa encontrada")
                    .font(.headline)
                    .foregroundColor(.primary)
                
                Text(viewModel.searchText.isEmpty && viewModel.selectedCategory == nil ?
                     "Comece adicionando uma nova tarefa" :
                     "Tente ajustar os filtros de pesquisa")
                    .font(.subheadline)
                    .foregroundColor(.secondary)
                    .multilineTextAlignment(.center)
            }
            
            if viewModel.searchText.isEmpty && viewModel.selectedCategory == nil {
                Button(action: { showingAddTask = true }) {
                    HStack {
                        Image(systemName: "plus")
                        Text("Adicionar Tarefa")
                    }
                    .font(.headline)
                    .foregroundColor(.white)
                    .padding(.horizontal, 24)
                    .padding(.vertical, 12)
                    .background(Color.blue)
                    .cornerRadius(10)
                }
            }
            
            Spacer()
        }
        .padding(.horizontal, 40)
    }
    
    // MARK: - Action Buttons
    private var actionButtonsView: some View {
        HStack {
            // Toggle completed tasks visibility
            Button(action: {
                viewModel.showCompletedTasks.toggle()
            }) {
                HStack(spacing: 6) {
                    Image(systemName: viewModel.showCompletedTasks ? "eye" : "eye.slash")
                        .font(.system(size: 14))
                    Text(viewModel.showCompletedTasks ? "Ocultar concluídas" : "Mostrar concluídas")
                        .font(.caption)
                }
                .foregroundColor(.blue)
            }
            
            Spacer()
            
            // Delete all tasks
            if !viewModel.tasks.isEmpty {
                Button(action: { showingDeleteAlert = true }) {
                    HStack(spacing: 6) {
                        Image(systemName: "trash")
                            .font(.system(size: 14))
                        Text("Eliminar todas")
                            .font(.caption)
                    }
                    .foregroundColor(.red)
                }
            }
        }
        .padding(.horizontal, 20)
        .padding(.vertical, 8)
    }
}

// MARK: - Supporting Views
struct StatCardView: View {
    let title: String
    let value: String
    let icon: String
    let color: Color
    
    var body: some View {
        VStack(spacing: 8) {
            HStack {
                Image(systemName: icon)
                    .font(.title3)
                    .foregroundColor(color)
                
                Spacer()
                
                Text(value)
                    .font(.title2)
                    .fontWeight(.bold)
                    .foregroundColor(.primary)
            }
            
            Text(title)
                .font(.caption)
                .fontWeight(.medium)
                .foregroundColor(.secondary)
                .frame(maxWidth: .infinity, alignment: .leading)
        }
        .padding(12)
        .background(
            RoundedRectangle(cornerRadius: 12)
                .fill(Color(.systemBackground))
                .shadow(color: .black.opacity(0.05), radius: 2, x: 0, y: 1)
        )
    }
}

struct CategoryFilterButton: View {
    let title: String
    var icon: String? = nil
    let isSelected: Bool
    let action: () -> Void
    
    var body: some View {
        Button(action: action) {
            HStack(spacing: 6) {
                if let icon = icon {
                    Image(systemName: icon)
                        .font(.system(size: 12))
                }
                Text(title)
                    .font(.caption)
                    .fontWeight(.medium)
            }
            .foregroundColor(isSelected ? .white : .primary)
            .padding(.horizontal, 12)
            .padding(.vertical, 6)
            .background(
                Capsule()
                    .fill(isSelected ? Color.blue : Color(.systemGray5))
            )
        }
    }
}

#Preview {
    ContentView()
}
