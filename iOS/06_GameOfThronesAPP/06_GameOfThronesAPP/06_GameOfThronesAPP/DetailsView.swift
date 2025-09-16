//
//  DetailsView.swift
//  06_GameOfThronesAPP
//
//  Created by Bruno Santos on 08/09/2025.
//

import SwiftUI

struct DetailsView: View {
    var body: some View {
        ZStack{
            Image("background")
                .resizable()
                .ignoresSafeArea()
                .scaledToFill()
                
            Image("jon")
                .resizable()
                .scaledToFit()
                .padding(20)
        }
    }
}

#Preview {
    DetailsView()
}
