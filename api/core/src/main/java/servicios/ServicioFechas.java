package festivosco.api.core.servicios;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ServicioFechas {


    public static LocalDate getDomingoPascua(int anio) {
        int a = anio % 19;
        int b = anio % 4;
        int c = anio % 7;
        int d = (19 * a + 24) % 30;

        int dias = d + (2 * b + 4 * c + 6 * d + 5) % 7;

        int dia = 22 + dias;
        int mes = 3; // marzo
        if (dia > 31) {
            dia -= 31;
            mes = 4; // abril
        }
        return LocalDate.of(anio, mes, dia);
    }


    public static LocalDate agregarDias(LocalDate fecha, int dias) {
        return fecha.plusDays(dias);
    }


    public static LocalDate siguienteLunes(LocalDate fecha) {
        DayOfWeek diaSemana = fecha.getDayOfWeek();
        if (diaSemana != DayOfWeek.MONDAY) {
            fecha = agregarDias(fecha, 8 - diaSemana.getValue());
        }
        return fecha;
    }
}
