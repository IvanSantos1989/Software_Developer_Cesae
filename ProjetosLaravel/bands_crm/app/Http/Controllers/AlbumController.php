<?php

namespace App\Http\Controllers;

use App\Models\Album;
use App\Models\Band;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Storage;

class AlbumController extends Controller
{
    
    public function index(Band $band)
    {
        $albums = $band->albums()->orderByDesc('release_date')->get();
        return view('albums.index', compact('band', 'albums'));
    }

    
    public function create(Request $request)
    {
        $this->authorizeAdmin();
        $bands = Band::orderBy('name')->get();
        $selected = $request->query('band_id');
        return view('albums.create', compact('bands','selected'));
    }

    
    public function store(Request $request)
    {
        $this->authorizeAdmin();

        $data = $request->validate([
            'band_id'      => ['required','exists:bands,id'],
            'name'         => ['required','string','max:150'],
            'image'        => ['nullable','image','max:2048'],
            'release_date' => ['nullable','date'],
        ]);

        if ($request->hasFile('image')) {
            $data['image_path'] = $request->file('image')->store('albums','public');
        }

        $album = Album::create([
            'band_id'      => $data['band_id'],
            'name'         => $data['name'],
            'image_path'   => $data['image_path'] ?? null,
            'release_date' => $data['release_date'] ?? null,
        ]);

        return redirect()
            ->route('bands.albums.index', $album->band_id)
            ->with('message','Álbum criado com sucesso!');
    }

    
    public function edit(Album $album)
    {
        $this->authorizeLogged();
        return view('albums.edit', compact('album'));
    }

    
    public function update(Request $request, Album $album)
    {
        $this->authorizeLogged();

        $data = $request->validate([
            'name'         => ['required','string','max:150'],
            'image'        => ['nullable','image','max:2048'],
            'release_date' => ['nullable','date'],
        ]);

        if ($request->hasFile('image')) {
            if ($album->image_path) {
                Storage::disk('public')->delete($album->image_path);
            }
            $data['image_path'] = $request->file('image')->store('albums','public');
        }

        $album->update([
            'name'         => $data['name'],
            'image_path'   => $data['image_path'] ?? $album->image_path,
            'release_date' => $data['release_date'] ?? null,
        ]);

        return redirect()
            ->route('bands.albums.index', $album->band_id)
            ->with('message','Álbum atualizado com sucesso!');
    }

    
    public function destroy(Album $album)
    {
        $this->authorizeAdmin();

        if ($album->image_path) {
            Storage::disk('public')->delete($album->image_path);
        }

        $band = $album->band_id;
        $album->delete();

        return redirect()
            ->route('bands.albums.index', $band)
            ->with('message','Álbum removido!');
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