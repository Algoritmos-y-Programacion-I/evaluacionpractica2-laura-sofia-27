package model;

public class Controller {

    private Pillar[] pillars;

    public Controller() {
        pillars = new Pillar[4];
        initializePillars();
    }

    private void initializePillars() {
        pillars[0] = new Pillar("Biodiversidad");
        pillars[1] = new Pillar("Agua");
        pillars[2] = new Pillar("Tratamiento de Basuras");
        pillars[3] = new Pillar("Energía");
    }

    /**
     * Descripcion: Agrega un nuevo proyecto a un pilar específico
     * 
     * @param pilarPosicion Posición del pilar (0 a 3)
     * @param id            ID del proyecto
     * @param name          Nombre del proyecto
     * @param description   Descripción del proyecto
     * @param status        Estado del proyecto (activo o inactivo)
     * @return boolean true si se agrega el proyecto, false en caso contrario
     */
    public boolean addProjectToPillar(int pilarPosicion, String id, String name, String description, boolean status) {
        if (pilarPosicion >= 0 && pilarPosicion < pillars.length) {
            Project newProject = new Project(id, name, description, status);
            return pillars[pilarPosicion].registerProject(newProject);
        }
        return false; // Pilar no válido
    }

    /**
     * Descripcion: Consulta los proyectos en un pilar específico
     * 
     * @param pilarPosicion Posición del pilar (0 a 3)
     * @return String lista con la información de los proyectos en el pilar
     */
    public String listProjectsInPillar(int pilarPosicion) {
        if (pilarPosicion >= 0 && pilarPosicion < pillars.length) {
            return pillars[pilarPosicion].getProjectList();
        }
        return "Pilar no encontrado."; // Pilar no válido
    }

    /**
     * Descripcion: Obtiene el nombre de un pilar específico
     * 
     * @param pilarPosicion Posición del pilar (0 a 3)
     * @return String nombre del pilar o mensaje de error
     */
    public String getPillarName(int pilarPosicion) {
        if (pilarPosicion >= 0 && pilarPosicion < pillars.length) {
            return pillars[pilarPosicion].getName();
        }
        return "Pilar no encontrado.";
    }
}
