//
//  StatsView.swift
//  Tasks to be done
//
//  Created by Developer on 18/09/2025.
//

import SwiftUI

struct StatsView: View {
    @ObservedObject var viewModel: TaskViewModel
    
    var body: some View {
        VStack(spacing: 20) {
            // Overall stats
            overallStatsSection
            
            // Category breakdown
            categoryStatsSection
            
            // Priority breakdown
            priorityStatsSection
        }
        .padding(.horizontal, 20)
    }
    
    // MARK: - Overall Stats Section
    private var overallStatsSection: some View {
        VStack(spacing: 16) {
            Text("Estatísticas Gerais")
                .font(.headline)
                .frame(maxWidth: .infinity, alignment: .leading)
            
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
            
            // Completion percentage
            if viewModel.totalTasksCount > 0 {
                VStack(spacing: 8) {
                    HStack {
                        Text("Progresso Geral")
                            .font(.subheadline)
                            .fontWeight(.medium)
                        
                        Spacer()
                        
                        Text("\(completionPercentage)%")
                            .font(.subheadline)
                            .fontWeight(.bold)
                            .foregroundColor(.green)
                    }
                    
                    ProgressView(value: Double(viewModel.completedTasksCount), total: Double(viewModel.totalTasksCount))
                        .progressViewStyle(LinearProgressViewStyle(tint: .green))
                }
                .padding(16)
                .background(
                    RoundedRectangle(cornerRadius: 12)
                        .fill(Color(.systemBackground))
                        .shadow(color: .black.opacity(0.05), radius: 2, x: 0, y: 1)
                )
            }
        }
    }
    
    // MARK: - Category Stats Section
    private var categoryStatsSection: some View {
        VStack(spacing: 16) {
            Text("Por Categoria")
                .font(.headline)
                .frame(maxWidth: .infinity, alignment: .leading)
            
            VStack(spacing: 8) {
                ForEach(viewModel.categoryStats, id: \.category) { stat in
                    CategoryStatRow(
                        category: stat.category,
                        total: stat.total,
                        completed: stat.completed
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
    
    // MARK: - Priority Stats Section
    private var priorityStatsSection: some View {
        VStack(spacing: 16) {
            Text("Por Prioridade")
                .font(.headline)
                .frame(maxWidth: .infinity, alignment: .leading)
            
            VStack(spacing: 8) {
                ForEach(TaskPriority.allCases) { priority in
                    PriorityStatRow(
                        priority: priority,
                        count: viewModel.getTasksCount(for: priority)
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
    
    // MARK: - Computed Properties
    private var completionPercentage: Int {
        guard viewModel.totalTasksCount > 0 else { return 0 }
        return Int((Double(viewModel.completedTasksCount) / Double(viewModel.totalTasksCount)) * 100)
    }
}

// MARK: - Supporting Views
struct CategoryStatRow: View {
    let category: TaskCategory
    let total: Int
    let completed: Int
    
    var body: some View {
        HStack(spacing: 12) {
            Image(systemName: category.iconName)
                .font(.title3)
                .foregroundColor(colorForCategory)
                .frame(width: 24)
            
            VStack(alignment: .leading, spacing: 2) {
                Text(category.rawValue)
                    .font(.subheadline)
                    .fontWeight(.medium)
                
                if total > 0 {
                    Text("\(completed)/\(total) concluídas")
                        .font(.caption)
                        .foregroundColor(.secondary)
                } else {
                    Text("Nenhuma tarefa")
                        .font(.caption)
                        .foregroundColor(.secondary)
                }
            }
            
            Spacer()
            
            if total > 0 {
                VStack(alignment: .trailing, spacing: 2) {
                    Text("\(percentage)%")
                        .font(.subheadline)
                        .fontWeight(.bold)
                        .foregroundColor(colorForCategory)
                    
                    Circle()
                        .trim(from: 0, to: CGFloat(percentage) / 100)
                        .stroke(colorForCategory, style: StrokeStyle(lineWidth: 3, lineCap: .round))
                        .rotationEffect(.degrees(-90))
                        .frame(width: 20, height: 20)
                        .overlay(
                            Circle()
                                .stroke(colorForCategory.opacity(0.2), lineWidth: 3)
                        )
                }
            } else {
                Text("—")
                    .font(.title3)
                    .foregroundColor(.secondary)
            }
        }
        .padding(.vertical, 4)
    }
    
    private var percentage: Int {
        guard total > 0 else { return 0 }
        return Int((Double(completed) / Double(total)) * 100)
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

struct PriorityStatRow: View {
    let priority: TaskPriority
    let count: Int
    
    var body: some View {
        HStack(spacing: 12) {
            Image(systemName: priority.iconName)
                .font(.title3)
                .foregroundColor(colorForPriority)
                .frame(width: 24)
            
            Text(priority.rawValue)
                .font(.subheadline)
                .fontWeight(.medium)
            
            Spacer()
            
            Text("\(count)")
                .font(.title3)
                .fontWeight(.bold)
                .foregroundColor(colorForPriority)
        }
        .padding(.vertical, 4)
    }
    
    private var colorForPriority: Color {
        switch priority {
        case .low: return .green
        case .medium: return .orange
        case .high: return .red
        }
    }
}

#Preview("Stats View") {
    StatsView(viewModel: TaskViewModel())
        .background(Color(.systemGroupedBackground))
}