public class Fish extends Animal
{
    private Boolean isSalty;

    public Boolean isSalty()
    {

        return true;
    }
}

class ClownFish extends Fish implements Feedable
{
    ClownFish()
    {
        setDiet("FishFood");
    }
}

class MantaRay extends Fish implements Feedable
{
    MantaRay()
    {
        setDiet("Plankton");
    }
}
