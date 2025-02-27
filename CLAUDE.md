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