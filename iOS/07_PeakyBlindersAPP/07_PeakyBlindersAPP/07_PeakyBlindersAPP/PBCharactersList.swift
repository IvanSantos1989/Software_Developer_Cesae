//
//  PBCharactersList.swift
//  07_PeakyBlindersAPP
//
//  Created by Bruno Santos on 16/09/2025.
//

import Foundation

class PBCharactersList {
    var allCharacters: [PBCharacter] = []
    
    init() {
        decodeJSONData()
    }
    
    func decodeJSONData(){
        if let url = Bundle.main.url(forResource: "peakyblinders", withExtension: "json"){
            do{
                let data = try Data(contentsOf: url)
                let decoder = JSONDecoder()
                decoder.keyDecodingStrategy = .convertFromSnakeCase
                allCharacters = try decoder.decode([PBCharacter].self, from: data)
                print(allCharacters.count)
            }catch{
                print("Error while decoding JSON data \(error)")
            }
        }
    }
}
