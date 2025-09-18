//
//  TaskItem.swift
//  Tasks to be done
//
//  Created by Developer on 18/09/2025.
//

import Foundation

// MARK: - Task Categories
enum TaskCategory: String, CaseIterable, Identifiable {
    case work = "Trabalho"
    case personal = "Pessoal"
    case shopping = "Compras"
    case health = "Saúde"
    case education = "Educação"
    
    var id: String { self.rawValue }
    
    var iconName: String {
        switch self {
        case .work:
            return "briefcase.fill"
        case .personal:
            return "person.fill"
        case .shopping:
            return "cart.fill"
        case .health:
            return "heart.fill"
        case .education:
            return "book.fill"
        }
    }
    
    var color: String {
        switch self {
        case .work:
            return "blue"
        case .personal:
            return "green"
        case .shopping:
            return "orange"
        case .health:
            return "red"
        case .education:
            return "purple"
        }
    }
}

// MARK: - Task Priority
enum TaskPriority: String, CaseIterable, Identifiable {
    case low = "Baixa"
    case medium = "Média"
    case high = "Alta"
    
    var id: String { self.rawValue }
    
    var iconName: String {
        switch self {
        case .low:
            return "arrow.down.circle.fill"
        case .medium:
            return "minus.circle.fill"
        case .high:
            return "arrow.up.circle.fill"
        }
    }
    
    var color: String {
        switch self {
        case .low:
            return "green"
        case .medium:
            return "yellow"
        case .high:
            return "red"
        }
    }
}

// MARK: - Task Images
enum TaskImage: String, CaseIterable, Identifiable {
    case meeting = "person.3.fill"
    case document = "doc.text.fill"
    case calendar = "calendar"
    case phone = "phone.fill"
    case email = "envelope.fill"
    case computer = "laptopcomputer"
    case book = "book.closed.fill"
    case shopping = "bag.fill"
    case home = "house.fill"
    case exercise = "figure.run"
    case food = "fork.knife"
    case travel = "airplane"
    case music = "music.note"
    case camera = "camera.fill"
    case game = "gamecontroller.fill"
    
    var id: String { self.rawValue }
    
    var displayName: String {
        switch self {
        case .meeting:
            return "Reunião"
        case .document:
            return "Documento"
        case .calendar:
            return "Calendário"
        case .phone:
            return "Telefone"
        case .email:
            return "Email"
        case .computer:
            return "Computador"
        case .book:
            return "Livro"
        case .shopping:
            return "Compras"
        case .home:
            return "Casa"
        case .exercise:
            return "Exercício"
        case .food:
            return "Comida"
        case .travel:
            return "Viagem"
        case .music:
            return "Música"
        case .camera:
            return "Foto"
        case .game:
            return "Jogo"
        }
    }
}

// MARK: - Task Item Model
struct TaskItem: Identifiable, Codable {
    let id = UUID()
    var title: String
    var description: String
    var category: TaskCategory
    var imageName: TaskImage
    var priority: TaskPriority
    var isCompleted: Bool
    var createdDate: Date
    var dueDate: Date?
    var completedDate: Date?
    
    init(title: String, 
         description: String, 
         category: TaskCategory, 
         imageName: TaskImage, 
         priority: TaskPriority = .medium,
         dueDate: Date? = nil) {
        self.title = title
        self.description = description
        self.category = category
        self.imageName = imageName
        self.priority = priority
        self.isCompleted = false
        self.createdDate = Date()
        self.dueDate = dueDate
        self.completedDate = nil
    }
    
    mutating func toggleCompletion() {
        isCompleted.toggle()
        completedDate = isCompleted ? Date() : nil
    }
}

// MARK: - Sample Data
extension TaskItem {
    static let sampleTasks: [TaskItem] = [
        TaskItem(
            title: "Reunião de projeto",
            description: "Apresentar o progresso do projeto para a equipe",
            category: .work,
            imageName: .meeting,
            priority: .high,
            dueDate: Calendar.current.date(byAdding: .day, value: 1, to: Date())
        ),
        TaskItem(
            title: "Comprar ingredientes",
            description: "Comprar ingredientes para o jantar de amanhã",
            category: .shopping,
            imageName: .shopping,
            priority: .medium,
            dueDate: Calendar.current.date(byAdding: .day, value: 2, to: Date())
        ),
        TaskItem(
            title: "Ler capítulo do livro",
            description: "Continuar a leitura do livro de programação Swift",
            category: .education,
            imageName: .book,
            priority: .low
        )
    ]
}