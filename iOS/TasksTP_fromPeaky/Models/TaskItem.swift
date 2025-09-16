import SwiftUI

struct TaskItem: Identifiable, Codable, Equatable {
    var id = UUID()
    var title: String
    var details: String
    var category: TaskCategory
    var imageName: String
}

enum TaskCategory: String, CaseIterable, Codable, Identifiable {
    case estudo = "Estudo"
    case trabalho = "Trabalho"
    case lazer = "Lazer"
    case saude = "Saúde"
    case outros = "Outros"
    
    var id: String { rawValue }
    var color: Color {
        switch self {
        case .estudo: return .blue
        case .trabalho: return .orange
        case .lazer: return .green
        case .saude: return .pink
        case .outros: return .gray
        }
    }
}
