// The Swift Programming Language
// https://docs.swift.org/swift-book

print("Hello, world!")

//
//  ContentView.swift
//  05_Ex1
//
//  Created on 08/09/2025.
//
 
import SwiftUI
 
struct ContentView: View {
    @State var playerCard = "back"
    @State var cpuCard = "back"
    
    @State var playerScore = 0
    @State var cpuScore = 0
    
    @State var backgroundImage = "background-plain"
 
    func buttonDealClicked() {
        let playerValue = Int.random(in: 2...14)
        let cpuValue = Int.random(in: 2...14)
        
        playerCard = "card" + String(playerValue)
        cpuCard = "card" + String(cpuValue)
        
        if playerValue > cpuValue {
            playerScore += 1
        } else if playerValue < cpuValue {
            cpuScore += 1
        }
    }
    
    func changeBackground() {
        // seleciona uma posição random do array
        let images = [
            "background-cloth",
            "background-plain",
            "background-wood-cartoon",
            "background-wood-grain"]
        
        backgroundImage = images[Int.random(in: 0...images.count-1)]
    }
    
    func changeBackground2(){
        // outra opção, baralha o array e seleciona sempre a primeira posição
        var images = [
            "background-cloth",
            "background-plain",
            "background-wood-cartoon",
            "background-wood-grain"]
        
        images.shuffle()
        backgroundImage = images[0]
    }
    
    var body: some View {
        ZStack{
            Image(backgroundImage)
                .resizable()
                .ignoresSafeArea()
            
            VStack{
                Spacer()
                
                Button{
                    changeBackground()
                }label:{
                    Image("logo")
                }
                
                Spacer()
                
                HStack{
                    Spacer()
                    Image(playerCard)
                    Spacer()
                    Image(cpuCard)
                    Spacer()
                }
                
                Spacer()
                
                Button {
                    buttonDealClicked()
                } label: {
                    Image("button")
                }
                
                Spacer()
                
                HStack{
                    Spacer()
                    VStack{
                        Text("Player")
                            .font(.headline)
                            .padding(.bottom, 10.0)
                        Text(String(playerScore))
                            .font(.largeTitle)
                    }
                    Spacer()
                    VStack{
                        Text("CPU")
                            .font(.headline)
                            .padding(.bottom, 10.0)
                        Text(String(cpuScore))
                            .font(.largeTitle)
                    }
                    Spacer()
                }
                .foregroundStyle(.white)
                Spacer()
            }
        }
    }
}
#Preview {
    ContentView()
}