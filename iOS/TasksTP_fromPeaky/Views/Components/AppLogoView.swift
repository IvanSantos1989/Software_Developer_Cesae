import SwiftUI

extension Color {
    static let appPrimary = Color(red: 0.12, green: 0.43, blue: 0.95)
    static let appSecondary = Color(red: 0.93, green: 0.96, blue: 1.00)
}

struct AppLogoView: View {
    var body: some View {
        ZStack {
            RoundedRectangle(cornerRadius: 24, style: .continuous)
                .fill(LinearGradient(colors: [.appPrimary, .blue.opacity(0.75)],
                                     startPoint: .topLeading, endPoint: .bottomTrailing))
                .frame(height: 140)
                .shadow(radius: 10)
            HStack(spacing: 16) {
                Image(systemName: "checkmark.seal.fill")
                    .font(.system(size: 52, weight: .bold))
                    .foregroundStyle(.white)
                    .shadow(radius: 2)
                VStack(alignment: .leading) {
                    Text("Tasks TP iOS").font(.title.bold()).foregroundStyle(.white)
                    Text("SwiftUI • Trabalho Prático").font(.subheadline).foregroundStyle(.white.opacity(0.9))
                }
            }.padding(.horizontal)
        }
        .padding(.vertical, 6)
    }
}

#Preview { AppLogoView().padding() }
