const moveRight = ({ options, maze }) => {
    const valueInt = parseInt(options.position_x_player)

    if (valueInt < maze[0].length - 1) {
        const result = valueInt + 1
        options.position_x_player = result + ''
    }
}
export default moveRight
