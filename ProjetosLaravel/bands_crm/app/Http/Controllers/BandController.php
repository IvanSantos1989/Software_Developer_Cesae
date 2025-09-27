<?php

namespace App\Http\Controllers;

use App\Models\Band;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Storage;

class BandController extends Controller
{
    // LISTA TODAS AS BANDAS (público)
    public function index()
    {
        $bands = Band::withCount('albums')->orderBy('name')->get();
        return view('bands.index', compact('bands'));
    }

    
    public function create()
    {
        $this->authorizeAdmin();
        return view('bands.create');
    }

    
    public function store(Request $request)
    {
        $this->authorizeAdmin();

        $data = $request->validate([
            'name'  => ['required','string','max:100','unique:bands,name'],
            'photo' => ['nullable','image','max:2048'],
        ]);

        if ($request->hasFile('photo')) {
            $data['photo_path'] = $request->file('photo')->store('bands','public');
        }

        Band::create($data);

        return redirect()->route('bands.index')->with('message','Banda criada com sucesso!');
    }

    
    public function edit(Band $band)
    {
        $this->authorizeLogged();
        return view('bands.edit', compact('band'));
    }

    
    public function update(Request $request, Band $band)
    {
        $this->authorizeLogged();

        $data = $request->validate([
            'name'  => ['required','string','max:100','unique:bands,name,'.$band->id],
            'photo' => ['nullable','image','max:2048'],
        ]);

        if ($request->hasFile('photo')) {
            if ($band->photo_path) {
                Storage::disk('public')->delete($band->photo_path);
            }
            $data['photo_path'] = $request->file('photo')->store('bands','public');
        }

        $band->update($data);

        return redirect()->route('bands.index')->with('message','Banda atualizada com sucesso!');
    }

    
    public function destroy(Band $band)
    {
        $this->authorizeAdmin();

        if ($band->photo_path) {
            Storage::disk('public')->delete($band->photo_path);
        }

        $band->delete();

        return redirect()->route('bands.index')->with('message','Banda removida!');
    }

    
    private function authorizeAdmin(): void
    {
        abort_unless(auth()->check() && auth()->user()->role === 'admin', 403);
    }

    private function authorizeLogged(): void
    {
        abort_unless(auth()->check(), 403);
    }
}