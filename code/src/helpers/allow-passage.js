export const allowPassage = ({ input, maze, options, blockedSurface }) => {
    let option = input.toUpperCase()
    let valueInt

    if (option === 'W') {
        valueInt = parseInt(options.position_y_player)
        if (valueInt > 0) {
            const result = valueInt - 1
            return blockedSurface[maze[result][options.position_x_player]]
        }
    }

    if (option === 'S') {
        valueInt = parseInt(options.position_y_player)

        if (valueInt < maze.length) {
            const result = valueInt + 1
            return blockedSurface[maze[result][options.position_x_player]]
        }
    }

    if (option === 'A') {
        valueInt = parseInt(options.position_x_player)

        if (valueInt > 0) {
            const result = valueInt - 1
            return blockedSurface[maze[options.position_y_player][result]]
        }
    }

    if (option === 'D') {
        valueInt = parseInt(options.position_x_player)

        if (valueInt < maze[0].length) {
            const result = valueInt + 1
            return blockedSurface[maze[options.position_y_player][result]]
        }
    }
}
