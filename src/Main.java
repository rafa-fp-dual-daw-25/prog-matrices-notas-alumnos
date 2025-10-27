import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[][] notas = {
                {8, 9, 8, 9, 10},
                {6, 6, 6, 8, 5},
                {7, 7, 7, 9, 10},
                {3, 1, 8, 9, 10},
                {3, 2, 1, 9, 10},
                {3, 7, 7, 9, 10}
        };

        System.out.println(Arrays.toString(notaMediaAlumnos(notas)));
        System.out.println(Arrays.toString(notaMediaAsignaturas(notas)));
        System.out.println(Arrays.toString(porcentajeAprobados(notas)));
    }

    //1
    public static int[] notaMediaAlumnos(int[][] matrix) {

        int[] notaMediaAlumnos = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            int suma = 0;
            for (int j = 0; j < matrix[0].length; j++) {
//                System.out.print(matrix[i][j] + " "); HACER EL PRINT AL PRINCIPIO PARA VER LA MATRIX
                suma += matrix[i][j];
            }
//            System.out.println(); HACER EL PRINT AL PRINCIPIO PARA VER LA MATRIX
            notaMediaAlumnos[i] = suma / matrix[i].length;
        }
        return notaMediaAlumnos;
    }

    public static int[] notaMediaAsignaturas(int[][] matrix) {

        int[] mediaAsignaturas = new int[matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {
            int asignatura = 0;
            for (int j = 0; j < matrix.length; j++) {
                asignatura += matrix[j][i];
            }
            mediaAsignaturas[i] = asignatura / matrix.length;
        }
        return mediaAsignaturas;
    }

    public static int[] porcentajeAprobados(int[][] matrix) {

        int[] porcentajeAprobados = new int[matrix.length];
        int contador = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[j][i] >= 5) {
                    contador++;
                }
            }
            porcentajeAprobados[i] = contador * 100 / matrix.length;
            contador = 0;
        }
        return porcentajeAprobados;
    }
}