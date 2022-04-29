const moveUp = ({ options }) => {
    const valueInt = parseInt(options.position_y_player)

    if (valueInt > 0) {
        const result = valueInt - 1
        options.position_y_player = result + ''
    }
}
export default moveUp
