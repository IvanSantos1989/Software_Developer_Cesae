//
//  AppLogoView.swift
//  Tasks to be done
//
//  Created by Developer on 18/09/2025.
//

import SwiftUI

struct AppLogoView: View {
    var size: CGFloat = 60
    var showText: Bool = true
    
    var body: some View {
        VStack(spacing: 8) {
            ZStack {
                // Background circle with gradient
                Circle()
                    .fill(
                        LinearGradient(
                            gradient: Gradient(colors: [
                                Color.blue.opacity(0.8),
                                Color.purple.opacity(0.8)
                            ]),
                            startPoint: .topLeading,
                            endPoint: .bottomTrailing
                        )
                    )
                    .frame(width: size, height: size)
                    .shadow(color: .blue.opacity(0.3), radius: 8, x: 0, y: 4)
                
                // Task icon
                Image(systemName: "checkmark.circle.fill")
                    .font(.system(size: size * 0.5, weight: .bold))
                    .foregroundColor(.white)
                
                // Overlay with subtle pattern
                Circle()
                    .stroke(
                        LinearGradient(
                            gradient: Gradient(colors: [
                                Color.white.opacity(0.3),
                                Color.clear
                            ]),
                            startPoint: .topLeading,
                            endPoint: .bottomTrailing
                        ),
                        lineWidth: 2
                    )
                    .frame(width: size, height: size)
            }
            
            if showText {
                VStack(spacing: 2) {
                    Text("Tasks")
                        .font(.title2)
                        .fontWeight(.bold)
                        .foregroundColor(.primary)
                    
                    Text("To Be Done")
                        .font(.caption)
                        .fontWeight(.medium)
                        .foregroundColor(.secondary)
                }
            }
        }
    }
}

// MARK: - Logo variants
struct MiniLogoView: View {
    var body: some View {
        AppLogoView(size: 30, showText: false)
    }
}

struct HeaderLogoView: View {
    var body: some View {
        HStack(spacing: 8) {
            AppLogoView(size: 40, showText: false)
            
            VStack(alignment: .leading, spacing: 2) {
                Text("Tasks")
                    .font(.title2)
                    .fontWeight(.bold)
                    .foregroundColor(.primary)
                
                Text("To Be Done")
                    .font(.caption)
                    .fontWeight(.medium)
                    .foregroundColor(.secondary)
            }
        }
    }
}

#Preview("App Logo") {
    VStack(spacing: 30) {
        AppLogoView()
        HeaderLogoView()
        MiniLogoView()
    }
    .padding()
}