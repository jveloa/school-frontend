package cu.edu.cujae.pweb.service;


import cu.edu.cujae.pweb.dto.NotaDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotaServiceImpl implements NotaService {

    @Override
    public List<NotaDto> getNotas() {

        List<NotaDto> users = new ArrayList<>();
        users.add(new NotaDto(1,1,1,1));
        users.add(new NotaDto(1,1,1,2));
        users.add(new NotaDto(1,1,1,3));
        users.add(new NotaDto(1,1,1,4));
        users.add(new NotaDto(1,1,1,5));
        users.add(new NotaDto(1,1,1,6));
        users.add(new NotaDto(1,1,1,7));
        users.add(new NotaDto(1,1,1,8));
        users.add(new NotaDto(1,1,1,9));
        return users;
    }

    public List<List<String>> getNotasTest(){
        List<List<String> >notas = new ArrayList<>();
        notas.add(new ArrayList(){{
            add("BD");
            add("4");
            add("3ro");
        }});

        notas.add(new ArrayList(){{
            add("SD");
            add("5");
            add("3ro");
        }});

        notas.add(new ArrayList(){{
            add("IA");
            add("5");
            add("3ro");
        }});

        notas.add(new ArrayList(){{
            add("BDA");
            add("4");
            add("3ro");
        }});

        notas.add(new ArrayList(){{
            add("MD");
            add("3");
            add("3ro");
        }});

        notas.add(new ArrayList(){{
            add("BD");
            add("5");

        }});


        return notas;
    }

   /* @Override
   public NotaDto getNota(int  codigo_asignatura, int codigo_anno, int codigo_estudiante) {
    }*/

    @Override
    public void createNota(NotaDto nota) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateNota(NotaDto nota) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteNota(int  codigo_asignatura, int codigo_anno, int codigo_estudiante) {
        // TODO Auto-generated method stub

    }
}
