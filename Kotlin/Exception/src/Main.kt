fun main()
{
    try {
        val res=10/0;
        println(res);
    }
    catch (e: Exception)
    {
        println(e)
    }
    finally{
        println("Done")
    }
}