
function CustomButton() {
    let content;
    let isLoggedIn = true;
    // if (isLoggedIn) {
    //     content = <button>Log Out</button>;
    // } else {
    //     content = <button>Log In</button>;
    // }
    return (
        <>
            {/*{content}*/}
            {
                isLoggedIn ? (
                    <button>Log Out</button>
                ) : (
                    <button>Log In</button>
                )
            }
        </>
    );
}
export default CustomButton;    // 외부에서 사용하려면 필수!