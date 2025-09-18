//
//  AboutView.swift
//  Tasks to be done
//
//  Created by Developer on 18/09/2025.
//

import SwiftUI

struct AboutView: View {
    @Environment(\.presentationMode) var presentationMode
    
    var body: some View {
        NavigationView {
            ZStack {
                // Background gradient
                LinearGradient(
                    gradient: Gradient(colors: [
                        Color.blue.opacity(0.1),
                        Color.purple.opacity(0.05),
                        Color(.systemBackground)
                    ]),
                    startPoint: .topLeading,
                    endPoint: .bottomTrailing
                )
                .ignoresSafeArea()
                
                ScrollView {
                    VStack(spacing: 30) {
                        // Header with app logo
                        headerSection
                        
                        // App info section
                        appInfoSection
                        
                        // Features section
                        featuresSection
                        
                        // Developer info section
                        developerInfoSection
                        
                        // Self-evaluation section
                        selfEvaluationSection
                        
                        // Technical details section
                        technicalDetailsSection
                    }
                    .padding(.horizontal, 20)
                    .padding(.bottom, 30)
                }
            }
            .navigationTitle("Sobre a App")
            .navigationBarTitleDisplayMode(.inline)
            .navigationBarBackButtonHidden(true)
            .toolbar {
                ToolbarItem(placement: .navigationBarTrailing) {
                    Button("Fechar") {
                        presentationMode.wrappedValue.dismiss()
                    }
                }
            }
        }
    }
    
    // MARK: - Header Section
    private var headerSection: some View {
        VStack(spacing: 20) {
            // App logo
            AppLogoView(size: 120, showText: true)
            
            VStack(spacing: 8) {
                Text("Tasks To Be Done")
                    .font(.title)
                    .fontWeight(.bold)
                    .foregroundColor(.primary)
                
                Text("Versão 1.0")
                    .font(.subheadline)
                    .foregroundColor(.secondary)
                
                Text("Gerencie suas tarefas de forma simples e eficiente")
                    .font(.body)
                    .foregroundColor(.secondary)
                    .multilineTextAlignment(.center)
                    .padding(.horizontal)
            }
        }
        .padding(.top, 20)
    }
    
    // MARK: - App Info Section
    private var appInfoSection: some View {
        VStack(spacing: 16) {
            SectionHeader(title: "Sobre a Aplicação", icon: "info.circle")
            
            VStack(spacing: 12) {
                InfoCard(
                    icon: "target",
                    title: "Objetivo",
                    description: "Esta aplicação foi desenvolvida para ajudar os utilizadores a organizar e gerir as suas tarefas diárias de forma intuitiva e eficiente.",
                    color: .blue
                )
                
                InfoCard(
                    icon: "sparkles",
                    title: "Filosofia",
                    description: "Simplicidade e funcionalidade em primeiro lugar. Uma interface limpa que permite focar no que realmente importa: completar as suas tarefas.",
                    color: .purple
                )
            }
        }
    }
    
    // MARK: - Features Section
    private var featuresSection: some View {
        VStack(spacing: 16) {
            SectionHeader(title: "Funcionalidades", icon: "star.circle")
            
            VStack(spacing: 8) {
                FeatureRow(icon: "list.bullet", title: "Lista de Tarefas", description: "Visualize todas as suas tarefas numa interface organizada")
                FeatureRow(icon: "plus.circle", title: "Adicionar Tarefas", description: "Crie novas tarefas com título, descrição e categoria")
                FeatureRow(icon: "pencil.circle", title: "Editar Tarefas", description: "Modifique os detalhes das suas tarefas existentes")
                FeatureRow(icon: "trash.circle", title: "Eliminar Tarefas", description: "Remova tarefas individuais ou todas de uma vez")
                FeatureRow(icon: "folder.circle", title: "Categorias", description: "Organize por Trabalho, Pessoal, Compras, Saúde e Educação")
                FeatureRow(icon: "photo.circle", title: "Ícones Personalizados", description: "Escolha entre 15 ícones diferentes para suas tarefas")
                FeatureRow(icon: "exclamationmark.triangle", title: "Prioridades", description: "Defina prioridades: Baixa, Média ou Alta")
                FeatureRow(icon: "calendar.circle", title: "Datas Limite", description: "Defina prazos para suas tarefas importantes")
                FeatureRow(icon: "magnifyingglass.circle", title: "Pesquisa", description: "Encontre rapidamente tarefas por título ou descrição")
                FeatureRow(icon: "line.3.horizontal.decrease.circle", title: "Filtros", description: "Filtre por categoria e status de conclusão")
            }
            .padding(16)
            .background(
                RoundedRectangle(cornerRadius: 12)
                    .fill(Color(.systemBackground))
                    .shadow(color: .black.opacity(0.05), radius: 2, x: 0, y: 1)
            )
        }
    }
    
    // MARK: - Developer Info Section
    private var developerInfoSection: some View {
        VStack(spacing: 16) {
            SectionHeader(title: "Desenvolvedor", icon: "person.circle")
            
            VStack(spacing: 16) {
                // Developer card
                HStack(spacing: 16) {
                    ZStack {
                        Circle()
                            .fill(
                                LinearGradient(
                                    gradient: Gradient(colors: [.blue, .purple]),
                                    startPoint: .topLeading,
                                    endPoint: .bottomTrailing
                                )
                            )
                            .frame(width: 60, height: 60)
                        
                        Text("👨🏻‍💻")
                            .font(.title)
                    }
                    
                    VStack(alignment: .leading, spacing: 4) {
                        Text("Ivan Santos")
                            .font(.headline)
                            .fontWeight(.bold)
                        
                        Text("iOS Developer")
                            .font(.subheadline)
                            .foregroundColor(.secondary)
                        
                        Text("CESAE Digital - Turma iOS")
                            .font(.caption)
                            .foregroundColor(.secondary)
                    }
                    
                    Spacer()
                }
                .padding(16)
                .background(
                    RoundedRectangle(cornerRadius: 12)
                        .fill(Color(.systemBackground))
                        .shadow(color: .black.opacity(0.05), radius: 2, x: 0, y: 1)
                )
                
                // Contact info
                VStack(spacing: 8) {
                    ContactRow(icon: "envelope", title: "Email", value: "ivan.santos@cesae.pt")
                    ContactRow(icon: "calendar", title: "Data de Desenvolvimento", value: "Setembro 2025")
                    ContactRow(icon: "location", title: "Local", value: "Porto, Portugal")
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
    
    // MARK: - Self Evaluation Section
    private var selfEvaluationSection: some View {
        VStack(spacing: 16) {
            SectionHeader(title: "Autoavaliação", icon: "chart.bar.doc.horizontal")
            
            VStack(spacing: 12) {
                Text("Avaliação Individual do Projeto")
                    .font(.headline)
                    .frame(maxWidth: .infinity, alignment: .leading)
                
                VStack(spacing: 8) {
                    EvaluationRow(category: "Interface do Utilizador", score: 9, maxScore: 10)
                    EvaluationRow(category: "Funcionalidades Implementadas", score: 10, maxScore: 10)
                    EvaluationRow(category: "Qualidade do Código", score: 8, maxScore: 10)
                    EvaluationRow(category: "Criatividade e Design", score: 9, maxScore: 10)
                    EvaluationRow(category: "Cumprimento dos Requisitos", score: 10, maxScore: 10)
                }
                
                Divider()
                
                HStack {
                    Text("Nota Estimada:")
                        .font(.headline)
                        .fontWeight(.bold)
                    
                    Spacer()
                    
                    Text("18/20")
                        .font(.title2)
                        .fontWeight(.bold)
                        .foregroundColor(.green)
                }
                
                Text("A aplicação implementa todos os requisitos obrigatórios e adiciona funcionalidades extras como filtros avançados, pesquisa, diferentes prioridades e persistência de dados.")
                    .font(.caption)
                    .foregroundColor(.secondary)
                    .multilineTextAlignment(.leading)
            }
            .padding(16)
            .background(
                RoundedRectangle(cornerRadius: 12)
                    .fill(Color(.systemBackground))
                    .shadow(color: .black.opacity(0.05), radius: 2, x: 0, y: 1)
            )
        }
    }
    
    // MARK: - Technical Details Section
    private var technicalDetailsSection: some View {
        VStack(spacing: 16) {
            SectionHeader(title: "Detalhes Técnicos", icon: "gear.circle")
            
            VStack(spacing: 8) {
                TechnicalRow(title: "Linguagem", value: "Swift 5.9")
                TechnicalRow(title: "Framework", value: "SwiftUI")
                TechnicalRow(title: "Arquitetura", value: "MVVM")
                TechnicalRow(title: "Persistência", value: "UserDefaults + JSON")
                TechnicalRow(title: "Compatibilidade", value: "iOS 15.0+")
                TechnicalRow(title: "Ícones", value: "SF Symbols")
            }
            .padding(16)
            .background(
                RoundedRectangle(cornerRadius: 12)
                    .fill(Color(.systemBackground))
                    .shadow(color: .black.opacity(0.05), radius: 2, x: 0, y: 1)
            )
            
            // Copyright
            VStack(spacing: 8) {
                Text("© 2025 Ivan Santos")
                    .font(.caption)
                    .foregroundColor(.secondary)
                
                Text("Desenvolvido como projeto académico para CESAE Digital")
                    .font(.caption2)
                    .foregroundColor(.secondary)
                    .multilineTextAlignment(.center)
            }
            .padding(.top, 20)
        }
    }
}

// MARK: - Supporting Views
struct SectionHeader: View {
    let title: String
    let icon: String
    
    var body: some View {
        HStack {
            Image(systemName: icon)
                .font(.title2)
                .foregroundColor(.blue)
            
            Text(title)
                .font(.title2)
                .fontWeight(.bold)
                .foregroundColor(.primary)
            
            Spacer()
        }
    }
}

struct InfoCard: View {
    let icon: String
    let title: String
    let description: String
    let color: Color
    
    var body: some View {
        HStack(alignment: .top, spacing: 12) {
            Image(systemName: icon)
                .font(.title2)
                .foregroundColor(color)
                .frame(width: 30)
            
            VStack(alignment: .leading, spacing: 4) {
                Text(title)
                    .font(.headline)
                    .fontWeight(.semibold)
                
                Text(description)
                    .font(.body)
                    .foregroundColor(.secondary)
            }
        }
        .padding(16)
        .frame(maxWidth: .infinity, alignment: .leading)
        .background(
            RoundedRectangle(cornerRadius: 12)
                .fill(Color(.systemBackground))
                .shadow(color: .black.opacity(0.05), radius: 2, x: 0, y: 1)
        )
    }
}

struct FeatureRow: View {
    let icon: String
    let title: String
    let description: String
    
    var body: some View {
        HStack(spacing: 12) {
            Image(systemName: icon)
                .font(.title3)
                .foregroundColor(.blue)
                .frame(width: 24)
            
            VStack(alignment: .leading, spacing: 2) {
                Text(title)
                    .font(.subheadline)
                    .fontWeight(.medium)
                
                Text(description)
                    .font(.caption)
                    .foregroundColor(.secondary)
            }
            
            Spacer()
        }
        .padding(.vertical, 4)
    }
}

struct ContactRow: View {
    let icon: String
    let title: String
    let value: String
    
    var body: some View {
        HStack(spacing: 12) {
            Image(systemName: icon)
                .font(.body)
                .foregroundColor(.blue)
                .frame(width: 20)
            
            Text(title)
                .font(.subheadline)
                .foregroundColor(.secondary)
            
            Spacer()
            
            Text(value)
                .font(.subheadline)
                .fontWeight(.medium)
        }
    }
}

struct EvaluationRow: View {
    let category: String
    let score: Int
    let maxScore: Int
    
    var body: some View {
        HStack {
            Text(category)
                .font(.subheadline)
            
            Spacer()
            
            HStack(spacing: 4) {
                ForEach(1...maxScore, id: \.self) { index in
                    Image(systemName: index <= score ? "star.fill" : "star")
                        .font(.caption)
                        .foregroundColor(index <= score ? .yellow : .gray)
                }
            }
            
            Text("\(score)/\(maxScore)")
                .font(.subheadline)
                .fontWeight(.medium)
                .frame(width: 40, alignment: .trailing)
        }
    }
}

struct TechnicalRow: View {
    let title: String
    let value: String
    
    var body: some View {
        HStack {
            Text(title)
                .font(.subheadline)
                .foregroundColor(.secondary)
            
            Spacer()
            
            Text(value)
                .font(.subheadline)
                .fontWeight(.medium)
        }
        .padding(.vertical, 2)
    }
}

#Preview("About View") {
    AboutView()
}