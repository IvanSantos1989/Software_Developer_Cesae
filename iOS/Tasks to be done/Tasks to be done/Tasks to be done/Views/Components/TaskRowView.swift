//
//  TaskRowView.swift
//  Tasks to be done
//
//  Created by Developer on 18/09/2025.
//

import SwiftUI

struct TaskRowView: View {
    let task: TaskItem
    let onToggleCompletion: () -> Void
    
    var body: some View {
        HStack(spacing: 12) {
            // Completion checkbox
            Button(action: onToggleCompletion) {
                ZStack {
                    Circle()
                        .stroke(task.isCompleted ? Color.green : Color.gray.opacity(0.5), lineWidth: 2)
                        .frame(width: 24, height: 24)
                    
                    if task.isCompleted {
                        Circle()
                            .fill(Color.green)
                            .frame(width: 24, height: 24)
                        
                        Image(systemName: "checkmark")
                            .font(.system(size: 12, weight: .bold))
                            .foregroundColor(.white)
                    }
                }
            }
            .buttonStyle(PlainButtonStyle())
            
            // Task icon
            ZStack {
                Circle()
                    .fill(colorForCategory(task.category).opacity(0.2))
                    .frame(width: 40, height: 40)
                
                Image(systemName: task.imageName.rawValue)
                    .font(.system(size: 18, weight: .medium))
                    .foregroundColor(colorForCategory(task.category))
            }
            
            // Task content
            VStack(alignment: .leading, spacing: 4) {
                HStack {
                    Text(task.title)
                        .font(.headline)
                        .fontWeight(.medium)
                        .foregroundColor(task.isCompleted ? .secondary : .primary)
                        .strikethrough(task.isCompleted)
                    
                    Spacer()
                    
                    // Priority indicator
                    HStack(spacing: 4) {
                        Image(systemName: task.priority.iconName)
                            .font(.system(size: 12))
                            .foregroundColor(colorForPriority(task.priority))
                        
                        Text(task.priority.rawValue)
                            .font(.caption2)
                            .fontWeight(.medium)
                            .foregroundColor(colorForPriority(task.priority))
                    }
                    .padding(.horizontal, 6)
                    .padding(.vertical, 2)
                    .background(
                        Capsule()
                            .fill(colorForPriority(task.priority).opacity(0.1))
                    )
                }
                
                Text(task.description)
                    .font(.subheadline)
                    .foregroundColor(task.isCompleted ? .secondary : .secondary)
                    .lineLimit(2)
                    .strikethrough(task.isCompleted)
                
                HStack {
                    // Category
                    HStack(spacing: 4) {
                        Image(systemName: task.category.iconName)
                            .font(.system(size: 10))
                        Text(task.category.rawValue)
                            .font(.caption2)
                    }
                    .foregroundColor(colorForCategory(task.category))
                    
                    Spacer()
                    
                    // Due date
                    if let dueDate = task.dueDate {
                        HStack(spacing: 4) {
                            Image(systemName: "calendar")
                                .font(.system(size: 10))
                            Text(dueDate, style: .date)
                                .font(.caption2)
                        }
                        .foregroundColor(isOverdue(dueDate) ? .red : .secondary)
                    }
                }
            }
            
            Spacer()
            
            // Navigation indicator
            Image(systemName: "chevron.right")
                .font(.system(size: 12, weight: .medium))
                .foregroundColor(.tertiary)
        }
        .padding(.vertical, 8)
        .padding(.horizontal, 16)
        .background(
            RoundedRectangle(cornerRadius: 12)
                .fill(Color(.systemBackground))
                .shadow(color: .black.opacity(0.05), radius: 2, x: 0, y: 1)
        )
        .opacity(task.isCompleted ? 0.7 : 1.0)
    }
    
    // MARK: - Helper Methods
    private func colorForCategory(_ category: TaskCategory) -> Color {
        switch category {
        case .work:
            return .blue
        case .personal:
            return .green
        case .shopping:
            return .orange
        case .health:
            return .red
        case .education:
            return .purple
        }
    }
    
    private func colorForPriority(_ priority: TaskPriority) -> Color {
        switch priority {
        case .low:
            return .green
        case .medium:
            return .orange
        case .high:
            return .red
        }
    }
    
    private func isOverdue(_ date: Date) -> Bool {
        return date < Date() && !task.isCompleted
    }
}

// MARK: - Compact Task Row
struct CompactTaskRowView: View {
    let task: TaskItem
    let onToggleCompletion: () -> Void
    
    var body: some View {
        HStack(spacing: 12) {
            Button(action: onToggleCompletion) {
                Image(systemName: task.isCompleted ? "checkmark.circle.fill" : "circle")
                    .font(.system(size: 20))
                    .foregroundColor(task.isCompleted ? .green : .gray)
            }
            .buttonStyle(PlainButtonStyle())
            
            Image(systemName: task.imageName.rawValue)
                .font(.system(size: 16))
                .foregroundColor(colorForCategory(task.category))
                .frame(width: 20)
            
            VStack(alignment: .leading, spacing: 2) {
                Text(task.title)
                    .font(.subheadline)
                    .fontWeight(.medium)
                    .strikethrough(task.isCompleted)
                
                Text(task.category.rawValue)
                    .font(.caption2)
                    .foregroundColor(.secondary)
            }
            
            Spacer()
            
            if let dueDate = task.dueDate {
                Text(dueDate, style: .date)
                    .font(.caption2)
                    .foregroundColor(isOverdue(dueDate) ? .red : .secondary)
            }
        }
        .opacity(task.isCompleted ? 0.6 : 1.0)
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
    
    private func isOverdue(_ date: Date) -> Bool {
        return date < Date() && !task.isCompleted
    }
}

#Preview("Task Row") {
    VStack(spacing: 16) {
        TaskRowView(task: TaskItem.sampleTasks[0]) { }
        TaskRowView(task: TaskItem.sampleTasks[1]) { }
        CompactTaskRowView(task: TaskItem.sampleTasks[2]) { }
    }
    .padding()
    .background(Color(.systemGroupedBackground))
}