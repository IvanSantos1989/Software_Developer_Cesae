import SwiftUI

struct AboutView: View {
    var body: some View {
        VStack(spacing: 16) {
            AppLogoView()
            VStack(spacing: 8) {
                Text("Criadores: Ivan e colega")
                Text("Extras: pesquisa na lista e persistência local (UserDefaults)")
                    .multilineTextAlignment(.center)
                Text("Autoavaliação: 19/20").font(.headline)
            }
            Spacer()
        }
        .padding()
    }
}

#Preview { AboutView() }
