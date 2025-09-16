//
//  PBCharacterDetail.swift
//  07_PeakyBlindersAPP
//
//  Created by Bruno Santos on 16/09/2025.
//

import SwiftUI

struct PBCharacterDetail: View {
    
    let character: PBCharacter
    
    var body: some View {
        VStack{
            Image(character.image)
                .resizable()
                .scaledToFill()
                .frame(height: 400)
                .offset(y:50)
                .clipped()
                .clipShape(.circle)
                .overlay(Circle().stroke(Color.white, lineWidth: 4))
                .padding()
            
            Text(character.name)
                .font(.title3)
                .fontWeight(.bold)
            
            Text(character.description)
                .padding()
                .multilineTextAlignment(.center)
        }
        .preferredColorScheme(.dark)
    }
}

#Preview {
    PBCharacterDetail(character: PBCharactersList().allCharacters[0])
}
