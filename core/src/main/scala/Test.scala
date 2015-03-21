object Main extends App {
	@Ant class A { def ask() = println("Oops..")}
	(new A).ask() // !! should print OK  (not Oops..)
}
