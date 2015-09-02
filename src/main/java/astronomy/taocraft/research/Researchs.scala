package astronomy.taocraft.research
/**
 * @author XFeng
 */
object Researchs {
  def researchlist():List[Research] = {
    defaultresearchlist();
  }
  def defaultresearchlist():List[Research] = {
     new Research("taiji","taocraft.research.name.taiji","item.taiji",250,450)::
     new Research("yuanqi","taocraft.research.name.yuanqi","item.yuanqi",230,400)::
     new Research("bagua","taocraft.research.name.bagua","item.bagua",270,400)::
     Nil;
  }
  def researchlinelist():List[Researchline] = {
    defaultresearchlinelist();
  }
  def defaultresearchlinelist():List[Researchline] = {
    new Researchline("taiji","yuanqi",List("metalwater"->3,"fireearth"->3))::
    new Researchline("taiji","bagua",List("metalwater"->1,"waterwood"->1,"woodfire"->1,"fireearth"->1,"earthmetal"->1))::
    Nil
  }
}