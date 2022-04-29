const moveLeft = ({ options }) => {
    const valueInt = parseInt(options.position_x_player)

    if (valueInt > 0) {
        const result = valueInt - 1
        options.position_x_player = result + ''
    }
}
export default moveLeft
