package Package_Mystigri;

public class Main
{

	public static void main(String[] args)
	{
		int NombreMystère, Proposition, i, Tentative, TentativeRestante;
		String Joueur1, Joueur2, Relancer;

		// Affichage du logo "Mystigri" et de l'en-tête
		System.out.println("					?|\\__/,|(\\");
		System.out.println("					 |o  o |_))");
		System.out.println("###\\    ###\\   ###   ###\\    #######\\    #########\\   #######\\    #######\\    ########\\    #######\\");
		System.out.println("####\\  #### |  ###   ### |  #########\\   ######### |  ####### |  #########\\   #########\\   ####### |");
		System.out.println("#####\\##### |   ### ###  |  ###  _### |  \\__###  __|  \\_###  _|  ###  _### |  ###  _### |  \\_###  _|");
		System.out.println("########### |   ### ###  |  ### | \\___|     ### |       ### |    ### | \\___|  ### | ### |    ### |");
		System.out.println("########### |    #####  /   ########\\       ### |       ### |    ### |####\\   ########  /    ### |");
		System.out.println("### ### ### |     ###  /     ########\\      ### |       ### |    ### |#### |  ######## |     ### |");
		System.out.println("###  #  ### |     ### |           ### |     ### |       ### |    ### | ### |  ### | ###|     ### |");
		System.out.println("### |\\_/### |     ### |     ###\\  ### |     ### |       ### |    ### | ### |  ### | ### \\    ### |");
		System.out.println("### |   ### |     ### |     ######### |     ### |     #######\\   ######### |  ### | ### |  #######\\");
		System.out.println("### |   ### |     ### |     \\#######  |     ### |     ####### |  \\#######  |  ### | ### |  ####### |");
		System.out.println("\\___|   \\___|     \\___|      \\_______/      \\___|     \\_______|   \\_______/   \\___| \\___|  \\_______|");
		System.out.println();
		System.out.println("				LE NOMBRE MYSTÈRE PAR JÉRÉMY & ELIAS");
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println();
		
		// Commencement de la boucle générale du jeu pour pouvoir par la suite rejouer ou non
		do
		{
		
			// Choix du pseudonyme du joueur 1 
			System.out.println(Couleur.couleur("Joueur 1", Couleur.CYAN) + ", vous choisirez le " + Couleur.couleur("nombre mystère", Couleur.YELLOW) + ".");
			Joueur1 = Couleur.couleur(Saisie.lire_String("Veuillez entrer votre pseudonyme :"), Couleur.CYAN);
			System.out.println();
			// Choix du pseudonyme du joueur 2
			System.out.println(Couleur.couleur("Joueur 2", Couleur.RED) + ", vous devinerez le "  + Couleur.couleur("nombre mystère", Couleur.YELLOW) + ".");
			Joueur2 = Couleur.couleur(Saisie.lire_String("Veuillez entrer votre pseudonyme :"), Couleur.RED);
			System.out.println();
			
			
			// Choix du NombreMystère
			NombreMystère = Saisie.lire_int(Joueur1 + ", choisissez un " + Couleur.couleur("nombre mystère", Couleur.YELLOW) + " compris entre 1 et 100 que " + Joueur2 + " devra deviner :");
			System.out.println();

			// Contrôle de la saisie du Nombre Mystère
			while((NombreMystère<1)||(NombreMystère>100))
			{
				System.out.println(Joueur1 + ", le nombre que vous avez choisi n'est pas compris entre 1 et 100 !");
				NombreMystère = Saisie.lire_int("Veuillez rentrer à nouveau le " + Couleur.couleur("nombre mystère", Couleur.YELLOW) + " :");
				System.out.println();
			}
			
			// Fait appelle à la class Clear
			Clear.clearConsole();

			// Informe les joueurs que le nombre mystère a bien été enregistré
			System.out.println(Joueur2 + ", le " + Couleur.couleur("nombre mystère", Couleur.YELLOW) + " a été choisi. Vous avez 10 tentatives pour le deviner :");

			// Boucle pour deviner le nombre mystère
			for (i = 10; i > 0; i--)
			{
				TentativeRestante = i-1; // Calcul du nombre de tentative restante
				Tentative = 10 - TentativeRestante; // Calcul du nombre de tentative nécessaire
				
				Proposition = Saisie.lire_int("Proposez un nombre :"); // Demande la proposition d'un nombre au joueur 2
				
				// Contrôle de la saisie du Nombre Mystère
				while((Proposition<1)||(Proposition>100))
				{
					System.out.println();
					System.out.println(Joueur2 + ", le nombre que vous avez choisi n'est pas compris entre 1 et 100 !");
					Proposition = Saisie.lire_int("Proposez à nouveau un nombre :");
				}
				
				System.out.println();
				// Si le nombre de tentative restante est égal à 0 alors, on annonce au joueur 2 sa défaite
				if (TentativeRestante == 0) System.out.println(Couleur.couleur("Perdu !", Couleur.RED) + " Le " + Couleur.couleur("nombre mystère", Couleur.YELLOW) + " était " + NombreMystère + " !");
					else if (Proposition > NombreMystère) System.out.println("Trop Haut ! Il vous reste " + TentativeRestante + " tentative(s)."); // Indique que la proposition est trop haute
						else if (Proposition < NombreMystère) System.out.println("Trop bas ! Il vous reste " + TentativeRestante + " tentative(s)."); // Indique que la proposition est trop basse
							else if (Proposition == NombreMystère) // Si le le nombre mystère été trouvé alors, on annonce au joueur 2 sa victoire et son nombre de tentative
							{
								System.out.println(Couleur.couleur("Gagné !", Couleur.GREEN) + " Le " + Couleur.couleur("nombre mystère", Couleur.YELLOW) + " était bien " + NombreMystère + ". Il vous a fallu " + Tentative + " tentative(s).");
								break; // Met fin à la boucle
							}
			}
			
			// Demande au joueur de rejouer ou non ?
			Relancer = Saisie.lire_String("Voulez-vous relancer une partie ? Oui ? Non ?");
		
			// Contrôle de la saisie de la réponse des joueurs
			while((Relancer.toUpperCase().equals("OUI") == false) && (Relancer.toUpperCase().equals("NON") == false))
			{
				Relancer = Saisie.lire_String("Voulez-vous relancer une partie ? Oui ? Non ?"); // Redemande la réponse aux joueurs
			}
			// Fait appelle à la class Clear
			if (Relancer.toUpperCase().equals("OUI")) Clear.clearConsole();
		}
			// Condition pour retourner ou non à la boucle générale
			while (Relancer.toUpperCase().equals("OUI") == true);
		
		// Bas de page
		System.out.println("");
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println("					MERCI D'AVOIR JOUÉ !");
	}
}
