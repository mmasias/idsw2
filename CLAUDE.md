# CLAUDE.md - Codebase Notes

## Repository Description
Educational repository for Software Engineering concepts. Contains course materials on software design principles, object-oriented programming, and SOLID principles, with Java examples.

## Code Style Guidelines
- **Classes**: PascalCase (Example: `ProcesarVenta`, `ValidarInventario`)
- **Methods**: camelCase (Example: `ejecutar`, `getNombre`)
- **Variables**: camelCase 
- **Packages**: lowercase (Example: `vConDF`, `vSinDF`)
- **Indentation**: 4 spaces
- **Fields**: Prefer private fields with getters/setters
- **Structure**: One class per file when possible
- **Imports**: Group by package, no wildcard imports

## Design Principles
- Follow SOLID principles (especially Single Responsibility)
- Prefer composition over inheritance when appropriate
- Use proper encapsulation (private fields, public methods)
- Design for maintainability and readability
- Modular design with clear responsibilities

## UML Diagrams
PlantUML files are in `/modelosUML/` directory with corresponding SVG outputs in `/images/modelosUML/`

## Project Structure
- `/temario/` - Main course materials organized by topic
  - `/00-introduccion/` - Introduction to software engineering
  - `/01-diseño/` - Design principles and concepts
    - `/src/relacionesClases/` - Java examples of class relationships
  - `/02-diseñoModular/` - Modular design and code smells
  - `/03-diseñoOO/` - Object-oriented design and SOLID principles
- `/documentos/` - Supplementary materials and articles
- `/modelosUML/` - PlantUML source files for diagrams
- `/images/` - Image resources, including generated UML diagrams

## Recent Work Summary
- **Repository Reorganization**:
  - Restructured directories to follow a consistent numbering pattern
  - Renamed files to follow a clear naming convention (number-name.md)
  - Organized content into logical hierarchies (01-solid, 02-principios, etc.)

- **Code Examples**:
  - Added Java examples in `/temario/01-diseño/src/relacionesClases/` to illustrate:
    - Composition relationship (EjemploComposicion.java)
    - Aggregation relationship (EjemploAgregacion.java)
    - Association relationship (EjemploAsociacion.java)
    - Use relationship (EjemploUso.java)
    - Combined system example (EjemploSistemaDocumentos.java)

- **Documentation Improvements**:
  - Added tutorial on selective Git changes with cherry-pick (git-cherry-pick-tutorial.md)
  - Created article on comments in educational code (comentarios-codigo-educativo.md)
  - Refined comments in example code to balance education and clarity

## Branches
- **main**: Stable version with core content
- **masIAs-y-CC**: Development branch with latest improvements
- **temp-main-changes**: Branch showing cherry-pick workflow (for reference)

## Next Steps
- Consider creating additional Java examples for other design concepts
- Potentially enhance documentation on SOLID principles with more examples
- Review and possibly improve UML diagrams for clarity