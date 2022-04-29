const moveDown = ({ options, maze }) => {
    const valueInt = parseInt(options.position_y_player)

    if (valueInt < maze.length - 1) {
        const result = valueInt + 1
        options.position_y_player = result + ''
    }
}
export default moveDown
