//
//  ContentView.swift
//  TASK TO DO
//  Created by Ivan Santos on 20/09/2025.
//

import SwiftUI

struct ContentView: View {
    
    let listCharacters = PBCharactersList().allCharacters
    
    var body: some View {
        NavigationStack{
            List(listCharacters){ character in
                NavigationLink{
                    PBCharacterDetail(character: character)
                } label: {
                    HStack{
                        Image(character.image)
                            .resizable()
                            .scaledToFit()
                            .frame(width: 85, height: 60)
                            .shadow(color:.white, radius: 1)
                        Text(character.name)
                            .fontWeight(.bold)
                    }
                }
            }.navigationTitle("TASK TO DO")
        }.preferredColorScheme(.dark)
    }
}

#Preview {
    ContentView()
}
