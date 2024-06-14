export interface Commande {

    dateCMD: Date;
    idCMD:number;
    id:number;
    client: {
      idClient: number;
      nom: string;
      prenom: string;
    };
  }
  