package Package_Mystigri;

public class Couleur
{
	// Séquences d'échappement ANSI pour les couleurs du texte
	public static final String RESET = "\u001B[0m"; // Arrêt du changement de couleur du texte
	public static final String BLACK = "\u001B[30m";// Changement de couleur du texte en NOIR
	public static final String RED = "\u001B[31m"; // Changement de couleur du texte en ROUGE
	public static final String GREEN = "\u001B[32m"; // Changement de couleur du texte en VERT
	public static final String YELLOW = "\u001B[33m"; // Changement de couleur du texte en JAUNE
	public static final String BLUE = "\u001B[34m"; // Changement de couleur du texte en BLEU
	public static final String PURPLE = "\u001B[35m"; // Changement de couleur du texte en VIOLERT
	public static final String CYAN = "\u001B[36m"; // Changement de couleur du texte en CYAN
	public static final String WHITE = "\u001B[37m"; // Changement de couleur du texte en BLANC

	public static String couleur(String text, String color) {
		return color + text + RESET; // Composition de la déclaration de changement de couleur
	}
}

