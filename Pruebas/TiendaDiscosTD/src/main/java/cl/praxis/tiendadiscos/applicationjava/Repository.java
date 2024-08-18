package cl.praxis.tiendadiscos.applicationjava;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    List<Miembro> miembros = new ArrayList<>();
    List<Disco> discos = new ArrayList<>();

    public Repository() {
        miembros.add(new Miembro(1, "Dulcie", "Uphill", 2, "Vinil II", 42000));
        miembros.add(new Miembro(2, "Renard", "Tegeller", 2, "Vinil II", 120990));
        miembros.add(new Miembro(3, "Etti", "Ecob", 1, "Vinil I", 66000));
        miembros.add(new Miembro(4, "Marcie", "Nestoruk", 1, "Vinil I", 13000));
        miembros.add(new Miembro(5, "Ericka", "Band", 1, "Vinil I", 63000));
        miembros.add(new Miembro(7, "Aldon", "Drieu", 2, "Vinil II", 57000));
        miembros.add(new Miembro(8, "Rhiamon", "Rennick", 2, "Vinil II", 34000));
        miembros.add(new Miembro(9, "Giffy", "Corington", 3, "Vinil III", 48000));
        miembros.add(new Miembro(10, "Valli", "Le - Count", 2, "Vinil II", 51000));
        miembros.add(new Miembro(11, "Caril", "Borrell", 2, "Vinil II", 76000));
        miembros.add(new Miembro(12, "Penny", "Eccleshare", 2, "Vinil II", 58990));
        miembros.add(new Miembro(14, "Meir", "Cropton", 3, "Vinil III", 76000));
        miembros.add(new Miembro(15, "Krystle", "Broschek", 2, "Vinil II", 63500));
        miembros.add(new Miembro(16, "Bing", "Haseley", 2, "Vinil II", 34000));
        miembros.add(new Miembro(17, "Merola", "Laurenceau", 1, "Vinil I", 111500));
        miembros.add(new Miembro(18, "Jim", "Naish", 3, "Vinil III", 45500));
        miembros.add(new Miembro(19, "Arleta", "MacAllaster", 3, "Vinil III", 48990));
        miembros.add(new Miembro(20, "Millicent", "Wibrew", 1, "Vinil I", 85000));
        miembros.add(new Miembro(21, "Katrina", "Roadknight", 1, "Vinil I", 35000));
        miembros.add(new Miembro(22, "Arley", "Priestnall", 2, "Vinil II", 33990));
        miembros.add(new Miembro(24, "Janenna", "Challin", 2, "Vinil II", 28000));
        miembros.add(new Miembro(25, "Juliana", "Bealing", 3, "Vinil III", 73000));

        discos.add(new Disco(1, "Disco 1", "Artista A", 7));
        discos.add(new Disco(2, "Disco 2", "Artista B", 3));
        discos.add(new Disco(3, "Disco 3", "Artista A", 10));
        discos.add(new Disco(4, "Disco 4", "Artista B", 5));
        discos.add(new Disco(5, "Disco 5", "Artista A", 2));
        discos.add(new Disco(6, "Disco 6", "Artista B", 8));
        discos.add(new Disco(7, "Disco 7", "Artista A", 6));
        discos.add(new Disco(8, "Disco 8", "Artista B", 4));
        discos.add(new Disco(9, "Disco 9", "Artista A", 9));
        discos.add(new Disco(10, "Disco 10", "Artista B", 1));
        discos.add(new Disco(11, "Disco 11", "Artista A", 7));
        discos.add(new Disco(12, "Disco 12", "Artista B", 3));
        discos.add(new Disco(13, "Disco 13", "Artista A", 10));
        discos.add(new Disco(14, "Disco 14", "Artista B", 5));
        discos.add(new Disco(15, "Disco 15", "Artista A", 2));
        discos.add(new Disco(16, "Disco 16", "Artista B", 8));
        discos.add(new Disco(17, "Disco 17", "Artista A", 6));
        discos.add(new Disco(18, "Disco 18", "Artista B", 4));
        discos.add(new Disco(19, "Disco 19", "Artista A", 9));
        discos.add(new Disco(20, "Disco 20", "Artista B", 8));
        discos.add(new Disco(21, "Disco 21", "Artista A", 7));
        discos.add(new Disco(22, "Disco 22", "Artista B", 3));
        discos.add(new Disco(23, "Disco 23", "Artista A", 10));
        discos.add(new Disco(24, "Disco 24", "Artista B", 5));
        discos.add(new Disco(25, "Disco 25", "Artista A", 2));
        discos.add(new Disco(26, "Disco 26", "Artista B", 8));
        discos.add(new Disco(27, "Disco 27", "Artista A", 6));
        discos.add(new Disco(28, "Disco 28", "Artista B", 4));
        discos.add(new Disco(29, "Disco 29", "Artista A", 9));
        discos.add(new Disco(30, "Disco 30", "Artista B", 1));
    }

    public List<Miembro> getMiembros() {
        return miembros;
    }

    public List<Disco> getDiscos() {
        return discos;
    }
}
