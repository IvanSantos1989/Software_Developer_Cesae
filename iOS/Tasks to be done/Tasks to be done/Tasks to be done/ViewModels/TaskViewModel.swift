//
//  TaskViewModel.swift
//  Tasks to be done
//
//  Created by Developer on 18/09/2025.
//

import Foundation
import SwiftUI

class TaskViewModel: ObservableObject {
    @Published var tasks: [TaskItem] = []
    @Published var searchText: String = ""
    @Published var selectedCategory: TaskCategory? = nil
    @Published var showCompletedTasks: Bool = true
    
    // MARK: - Computed Properties
    var filteredTasks: [TaskItem] {
        var filtered = tasks
        
        // Filter by search text
        if !searchText.isEmpty {
            filtered = filtered.filter { task in
                task.title.localizedCaseInsensitiveContains(searchText) ||
                task.description.localizedCaseInsensitiveContains(searchText)
            }
        }
        
        // Filter by category
        if let category = selectedCategory {
            filtered = filtered.filter { $0.category == category }
        }
        
        // Filter by completion status
        if !showCompletedTasks {
            filtered = filtered.filter { !$0.isCompleted }
        }
        
        return filtered.sorted { task1, task2 in
            // Sort completed tasks to bottom
            if task1.isCompleted != task2.isCompleted {
                return !task1.isCompleted
            }
            
            // Sort by priority
            let priority1 = priorityValue(task1.priority)
            let priority2 = priorityValue(task2.priority)
            
            if priority1 != priority2 {
                return priority1 > priority2
            }
            
            // Sort by due date (if exists)
            if let date1 = task1.dueDate, let date2 = task2.dueDate {
                return date1 < date2
            } else if task1.dueDate != nil {
                return true
            } else if task2.dueDate != nil {
                return false
            }
            
            // Finally sort by creation date
            return task1.createdDate > task2.createdDate
        }
    }
    
    var completedTasksCount: Int {
        tasks.filter { $0.isCompleted }.count
    }
    
    var totalTasksCount: Int {
        tasks.count
    }
    
    var pendingTasksCount: Int {
        tasks.filter { !$0.isCompleted }.count
    }
    
    // MARK: - Initialization
    init() {
        loadTasks()
    }
    
    // MARK: - Task Management
    func addTask(_ task: TaskItem) {
        tasks.append(task)
        saveTasks()
    }
    
    func updateTask(_ task: TaskItem) {
        if let index = tasks.firstIndex(where: { $0.id == task.id }) {
            tasks[index] = task
            saveTasks()
        }
    }
    
    func deleteTask(_ task: TaskItem) {
        tasks.removeAll { $0.id == task.id }
        saveTasks()
    }
    
    func deleteTask(at offsets: IndexSet) {
        let tasksToDelete = offsets.map { filteredTasks[$0] }
        for task in tasksToDelete {
            deleteTask(task)
        }
    }
    
    func deleteAllTasks() {
        tasks.removeAll()
        saveTasks()
    }
    
    func deleteAllCompletedTasks() {
        tasks.removeAll { $0.isCompleted }
        saveTasks()
    }
    
    func toggleTaskCompletion(_ task: TaskItem) {
        if let index = tasks.firstIndex(where: { $0.id == task.id }) {
            tasks[index].toggleCompletion()
            saveTasks()
        }
    }
    
    func markAllAsCompleted() {
        for index in tasks.indices {
            if !tasks[index].isCompleted {
                tasks[index].toggleCompletion()
            }
        }
        saveTasks()
    }
    
    func markAllAsIncomplete() {
        for index in tasks.indices {
            if tasks[index].isCompleted {
                tasks[index].toggleCompletion()
            }
        }
        saveTasks()
    }
    
    // MARK: - Filter Methods
    func clearFilters() {
        searchText = ""
        selectedCategory = nil
        showCompletedTasks = true
    }
    
    func setCategory(_ category: TaskCategory?) {
        selectedCategory = category
    }
    
    // MARK: - Helper Methods
    private func priorityValue(_ priority: TaskPriority) -> Int {
        switch priority {
        case .high:
            return 3
        case .medium:
            return 2
        case .low:
            return 1
        }
    }
    
    func getTask(by id: UUID) -> TaskItem? {
        return tasks.first { $0.id == id }
    }
    
    // MARK: - Persistence
    private func saveTasks() {
        if let encoded = try? JSONEncoder().encode(tasks) {
            UserDefaults.standard.set(encoded, forKey: "SavedTasks")
        }
    }
    
    private func loadTasks() {
        if let data = UserDefaults.standard.data(forKey: "SavedTasks"),
           let decodedTasks = try? JSONDecoder().decode([TaskItem].self, from: data) {
            self.tasks = decodedTasks
        } else {
            // Load sample data if no saved tasks
            self.tasks = TaskItem.sampleTasks
            saveTasks()
        }
    }
    
    // MARK: - Statistics
    func getTasksCount(for category: TaskCategory) -> Int {
        return tasks.filter { $0.category == category }.count
    }
    
    func getCompletedTasksCount(for category: TaskCategory) -> Int {
        return tasks.filter { $0.category == category && $0.isCompleted }.count
    }
    
    func getTasksCount(for priority: TaskPriority) -> Int {
        return tasks.filter { $0.priority == priority }.count
    }
    
    var categoryStats: [(category: TaskCategory, total: Int, completed: Int)] {
        return TaskCategory.allCases.map { category in
            let total = getTasksCount(for: category)
            let completed = getCompletedTasksCount(for: category)
            return (category, total, completed)
        }
    }
}