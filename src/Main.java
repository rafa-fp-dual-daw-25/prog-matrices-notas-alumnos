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

        int[][] printTable = ordenSegunMedia(notas);
        for (int[] ints : printTable) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        System.out.println(Arrays.deepToString(mejoresAlumnosPorAsignatura(notas)));

        int[][] mejoresAlumnosPorAsignatura = mejoresAlumnosPorAsignatura(notas);

        for (int i = 0; i < mejoresAlumnosPorAsignatura.length; i++) {
            int alumno = mejoresAlumnosPorAsignatura[i][0];
            int nota = mejoresAlumnosPorAsignatura[i][1];
            System.out.println("Asignatura " + i + ": Alumno " + alumno + " con nota " + nota);
        }
    }

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

        int[] porcentajeAprobados = new int[matrix[0].length];
        int contador = 0;

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] >= 5) {
                    contador++;
                }
            }
            porcentajeAprobados[i] = contador * 100 / matrix.length;
            contador = 0;
        }
        return porcentajeAprobados;
    }

    public static int[][] ordenSegunMedia(int[][] matrix) {

        int[] sumas = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            int suma = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                suma += matrix[i][j];
            }
            sumas[i] = suma;
        }

        //ORDENACION BURBUJA
        for (int i = 0; i < sumas.length - 1; i++) {
            for (int j = 0; j < sumas.length - i - 1; j++) {
                if (sumas[j] > sumas[j + 1]) {

                    int tempSuma = sumas[j];
                    sumas[j] = sumas[j + 1];
                    sumas[j + 1] = tempSuma;

                    int[] tempFila = matrix[j];
                    matrix[j] = matrix[j + 1];
                    matrix[j + 1] = tempFila;
                }
            }
        }
        return matrix;
    }

    public static int[][] mejoresAlumnosPorAsignatura(int[][] matrix) {

        int numAsignaturas = matrix[0].length;
        int[][] resultado = new int[numAsignaturas][2]; // [asignatura][mejor_alumno, nota]

        for (int i = 0; i < numAsignaturas; i++) {
            int mejorNota = -1;
            int mejorAlumno = -1;

            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] > mejorNota) {
                    mejorNota = matrix[j][i];
                    mejorAlumno = j;
                }
            }
            resultado[i][0] = mejorAlumno;
            resultado[i][1] = mejorNota;
        }
        return resultado;
    }
}