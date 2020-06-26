package iCalendar;

public class Evenement
{
    private String DateEvent;
    private String Objet;
    private String ID;
    private String Str_Hfin;
    private String Lieu;
    private String Str_Hdeb;

    public String getDateEvent ()
    {
        return DateEvent;
    }

    public void setDateEvent (String DateEvent)
    {
        this.DateEvent = DateEvent;
    }

    public String getObjet ()
    {
        return Objet;
    }

    public void setObjet (String Objet)
    {
        this.Objet = Objet;
    }

    public String getID ()
    {
        return ID;
    }

    public void setID (String ID)
    {
        this.ID = ID;
    }

    public String getStr_Hfin ()
    {
        return Str_Hfin;
    }

    public void setStr_Hfin (String Str_Hfin)
    {
        this.Str_Hfin = Str_Hfin;
    }

    public String getLieu ()
    {
        return Lieu;
    }

    public void setLieu (String Lieu)
    {
        this.Lieu = Lieu;
    }

    public String getStr_Hdeb ()
    {
        return Str_Hdeb;
    }

    public void setStr_Hdeb (String Str_Hdeb)
    {
        this.Str_Hdeb = Str_Hdeb;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [DateEvent = "+DateEvent+", Objet = "+Objet+", ID = "+ID+", Str_Hfin = "+Str_Hfin+", Lieu = "+Lieu+", Str_Hdeb = "+Str_Hdeb+"]";
    }
}


