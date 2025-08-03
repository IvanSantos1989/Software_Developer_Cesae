<?php

namespace App\Http\Controllers;

use App\Models\Book;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class BookController extends Controller
{
    public function allBooks(){
        $books = $this->getAllBooks();
        return view('books.all_books', compact('books'));
    }

    //função que retorna a view de um book (o que estámos a clicar)
    public function viewBook($id){
        $myBook = Book::join('users', 'users.id', '=', 'books.user_id')
            ->select('books.*', 'users.name as username')
            ->where('books.id', $id)
            ->first();

        $users = DB::table('users')->get();

        return view('books.show_book', compact('myBook', 'users'));
    }

    //função que atualiza um book com base no id
    public function updateBook(Request $request){
        $request->validate([
            'name' => 'required',
            'estimated_price' => 'required|numeric',
            'paid_price' => 'nullable|numeric',
            'user_id' => 'required',
        ]);

        Book::where('id', $request->id)
            ->update([
                'name' => $request->name,
                'estimated_price' => $request->estimated_price,
                'paid_price' => $request->paid_price,
                'user_id' => $request->user_id,
                'updated_at' => now()
            ]);

        return redirect()->route('books.all')->with('message', 'Book updated successfully!');
    }

    //função que apaga um book com base no id
    public function deleteBook($id){
        Book::where('id', $id)->delete();
        return back();
    }

    //função que carrega a view para adicionar um book
    public function createBook(){
        $users = DB::table('users')->select('id', 'name')->get();
        return view('books.add_book', compact('users'));
    }

    //função que guarda um book na base de dados
    public function storeBook(Request $request){
        $request->validate([
            'name' => 'required|string',
            'estimated_price' => 'required|numeric',
            'paid_price' => 'nullable|numeric',
            'user_id' => 'required|exists:users,id',
        ]);

        Book::insert([
            'name' => $request->name,
            'estimated_price' => $request->estimated_price,
            'paid_price' => $request->paid_price,
            'user_id' => $request->user_id,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        return redirect()->route('books.all')->with('message', 'Book added successfully!');
    }

    private function getAllBooks(){
        $books = Book::join('users', 'users.id', '=', 'books.user_id')
        ->select('books.*', 'users.name as username')
        ->get();

        return $books;
    }
}
