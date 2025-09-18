# Tasks To Be Done - iOS App

Uma aplicação iOS completa para gestão de tarefas desenvolvida em Swift e SwiftUI.

## 📱 Sobre a Aplicação

Esta app de Lista de Tarefas (ToDo List) foi desenvolvida como projeto académico para o curso de iOS Development na CESAE Digital. A aplicação permite aos utilizadores gerir as suas tarefas diárias de forma simples e eficiente.

## ✅ Requisitos Implementados

### 1. Lista de Tarefas ✓

- ✅ Exibir lista de tarefas com design moderno
- ✅ Cada tarefa tem título, descrição, categoria e imagem
- ✅ Navegação para criação de nova tarefa
- ✅ Elementos adicionais: prioridade, data limite, data de criação

### 2. Adicionar Tarefa ✓

- ✅ Layout completo para criação de tarefas
- ✅ Seleção entre 5 categorias pré-definidas
- ✅ Seleção de imagem entre 15 ícones disponíveis
- ✅ Validações de formulário

### 3. Edição e Remoção ✓

- ✅ Editar detalhes de tarefas existentes
- ✅ Remover tarefas individuais
- ✅ Remover todas as tarefas de uma vez
- ✅ Confirmações de segurança

### 4. Sobre a APP ✓

- ✅ Identificação do criador
- ✅ Informação sobre elementos adicionais
- ✅ Autoavaliação individual detalhada

### 5. Elementos Obrigatórios ✓

- ✅ Utilização extensiva de SF Symbols
- ✅ Personalização de cores por categoria
- ✅ Aplicação de ZStack em múltiplos componentes
- ✅ Logo personalizada da aplicação

## 🎨 Funcionalidades Extras

### Funcionalidades Avançadas

- 🔍 **Pesquisa**: Busca por título e descrição
- 🏷️ **Filtros**: Por categoria e status de conclusão
- ⭐ **Prioridades**: Baixa, Média, Alta com cores distintivas
- 📅 **Datas Limite**: Com indicação de atraso
- 📊 **Estatísticas**: Progresso geral e por categoria
- 💾 **Persistência**: Dados salvos automaticamente
- 🌙 **Tema**: Suporte a modo escuro/claro do sistema

### Interface Moderna

- Gradientes e sombras suaves
- Animações e transições
- Design responsivo
- Componentes reutilizáveis
- Interface intuitiva

## 🏗️ Arquitetura

### Estrutura de Pastas

```
Tasks to be done/
├── Models/
│   └── TaskItem.swift              # Modelo de dados e enums
├── ViewModels/
│   └── TaskViewModel.swift         # Lógica de negócio (MVVM)
├── Views/
│   ├── ContentView.swift           # Vista principal
│   ├── AddEditTaskView.swift       # Formulário de criação/edição
│   ├── TaskDetailView.swift        # Detalhes da tarefa
│   ├── AboutView.swift             # Página sobre a app
│   └── Components/
│       ├── AppLogoView.swift       # Logo da aplicação
│       ├── TaskRowView.swift       # Componente de linha de tarefa
│       └── StatsView.swift         # Componente de estatísticas
└── Tasks_to_be_doneApp.swift       # Arquivo principal da app
```

### Padrão Arquitetural

- **MVVM (Model-View-ViewModel)**: Separação clara de responsabilidades
- **ObservableObject**: Gestão reativa do estado
- **SwiftUI**: Interface declarativa moderna

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: Swift 5.9
- **Framework**: SwiftUI
- **Persistência**: UserDefaults + JSON
- **Ícones**: SF Symbols
- **Compatibilidade**: iOS 15.0+
- **Arquitetura**: MVVM

## 📋 Modelos de Dados

### TaskItem

```swift
struct TaskItem {
    let id: UUID
    var title: String
    var description: String
    var category: TaskCategory
    var imageName: TaskImage
    var priority: TaskPriority
    var isCompleted: Bool
    var createdDate: Date
    var dueDate: Date?
    var completedDate: Date?
}
```

### Categorias (5 obrigatórias)

1. **Trabalho** - Azul
2. **Pessoal** - Verde
3. **Compras** - Laranja
4. **Saúde** - Vermelho
5. **Educação** - Roxo

### Prioridades

- **Alta** - Vermelho
- **Média** - Laranja
- **Baixa** - Verde

### Ícones Disponíveis (15)

Reunião, Documento, Calendário, Telefone, Email, Computador, Livro, Compras, Casa, Exercício, Comida, Viagem, Música, Foto, Jogo

## 🚀 Como Usar

### Transferir para Xcode

1. Copie toda a pasta `Tasks to be done`
2. Abra o projeto `.xcodeproj` no Xcode
3. Compile e execute no simulador ou dispositivo

### Funcionalidades Principais

1. **Adicionar Tarefa**: Toque no botão `+` para criar nova tarefa
2. **Ver Detalhes**: Toque numa tarefa para ver detalhes completos
3. **Editar**: Use o menu de três pontos ou botão editar
4. **Marcar Concluída**: Toque no círculo à esquerda da tarefa
5. **Filtrar**: Use os botões de categoria para filtrar
6. **Pesquisar**: Digite na barra de pesquisa
7. **Sobre**: Toque no ícone de informação

## 📊 Cotação Esperada

| Requisito                                 | Cotação | Status       |
| ----------------------------------------- | ------- | ------------ |
| 1a - Lista de tarefas                     | 1.5     | ✅ Completo  |
| 1b - Título, descrição, categoria, imagem | 1.0     | ✅ Completo  |
| 1c - Navegação para criação               | 1.0     | ✅ Completo  |
| 2a - Layout de criação                    | 2.0     | ✅ Completo  |
| 2b - Seleção de categoria                 | 1.5     | ✅ Completo  |
| 2c - Seleção de imagem                    | 2.0     | ✅ Completo  |
| 3a - Edição de tarefas                    | 2.0     | ✅ Completo  |
| 3b - Remoção individual                   | 2.0     | ✅ Completo  |
| 3c - Remoção de todas                     | 2.0     | ✅ Completo  |
| 4a - Identificação do criador             | 0.3     | ✅ Completo  |
| 4b - Elementos não pedidos                | 0.3     | ✅ Completo  |
| 4c - Autoavaliação                        | 0.4     | ✅ Completo  |
| 5a - SF Symbols                           | 1.0     | ✅ Completo  |
| 5b - Personalização de cores              | 1.0     | ✅ Completo  |
| 5c - ZStack                               | 1.0     | ✅ Completo  |
| 5d - Logo                                 | 1.0     | ✅ Completo  |
| **TOTAL**                                 | **20**  | **✅ 20/20** |

## 👨🏻‍💻 Desenvolvedor

**Ivan Santos**

- iOS Developer em formação
- CESAE Digital - Turma iOS
- Porto, Portugal
- Setembro 2025

## 📄 Licença

Este projeto foi desenvolvido como projeto académico para CESAE Digital.
© 2025 Ivan Santos

---

_"Simplicidade e funcionalidade em primeiro lugar - uma interface limpa que permite focar no que realmente importa: completar as suas tarefas."_
