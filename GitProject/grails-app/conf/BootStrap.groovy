import gitproject.Placements

class BootStrap {

    def init = { servletContext ->
    def fredplace = new Placements(name:"Fred", coursecode:"3").save();
    def joeplace = new Placements(name:"Joe", coursecode:"4").save();
    }
    def destroy = {
    }
}
